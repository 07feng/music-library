<template>
  <yin-login-logo></yin-login-logo>
  <div class="sign">
    <div class="sign-head">
      <span>账号登录</span>
    </div>
    <el-form :model="registerForm" ref="signInForm" :rules="SignInRules" status-icon>
      <el-form-item prop="username">
        <el-input placeholder="用户名" v-model="registerForm.username"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          type="password"
          placeholder="密码"
          v-model="registerForm.password"
          @keyup.enter="handleLoginIn"
        ></el-input>
      </el-form-item>
      <el-form-item class="sign-btn">
        <el-button @click="handleSignUp">注册</el-button>
        <el-button type="primary" @click="handleLoginIn">登录</el-button>
        <el-button @click="handleForgotPassword">忘记密码</el-button>
        <el-button @click="handleEmail">邮箱登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, getCurrentInstance } from 'vue'
import mixin from '@/mixins/mixin'
import YinLoginLogo from '@/components/layouts/YinLoginLogo.vue'
import { HttpManager,ResponseBody } from '@/api'
import { NavName, RouterName, SignInRules } from '@/enums'

export default defineComponent({
  components: {
    YinLoginLogo
  },
  setup() {
    const { proxy } = getCurrentInstance()
    const { routerManager, changeIndex } = mixin()

    const registerForm = reactive({
      username: '',
      password: ''
    })

    async function handleLoginIn() {
      let canRun = true;
      (proxy.$refs['signInForm'] as any).validate((valid) => {
        if (!valid) {
          return (canRun = false)
        }
      })
      if (!canRun) {
        return
      }

      try {
        const username = registerForm.username
        const password = registerForm.password
        const result = (await HttpManager.signIn({ username, password })) as ResponseBody;
        (proxy as any).$message({
          message: result.message,
          type: result.type
        })
        if (result.success) {
          proxy.$store.commit('setUserId', result.data[0].id)
          proxy.$store.commit('setUserName', result.data[0].username)
          proxy.$store.commit('setUserPic', result.data[0].avator)
          proxy.$store.commit('setToken', true)
          changeIndex(NavName.Home)
          routerManager(RouterName.Home, { path: RouterName.Home })
        }
      } catch (error) {
        console.error(error)
      }
    }

    function handleSignUp() {
      routerManager(RouterName.SignUp, { path: RouterName.SignUp })
    }

    function handleForgotPassword() {
      routerManager(RouterName.ForgotPassword, { path: RouterName.ForgotPassword })
    }

    function handleEmail() {
      routerManager(RouterName.loginByEmail, { path: RouterName.loginByEmail })
    }

    return {
      registerForm,
      SignInRules,
      handleLoginIn,
      handleForgotPassword,
      handleEmail,
      handleSignUp
    }
  }
})
</script>
