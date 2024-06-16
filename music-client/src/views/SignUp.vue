<template>
  <yin-login-logo></yin-login-logo>
  <div class="sign">
    <div class="sign-head">
      <span>用户注册</span>
    </div>
    <el-form
      :model="registerForm"
      ref="signUpForm"
      :rules="SignInRules"
      label-width="70px"
      status-icon
    >
      <el-form-item label="用户名" prop="username">
        <el-input v-model="registerForm.username" placeholder="请输入用户名"></el-input>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="registerForm.password" placeholder="请输入密码"></el-input>
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-radio-group v-model="registerForm.sex">
          <el-radio :label="0">女</el-radio>
          <el-radio :label="1">男</el-radio>
          <el-radio :label="2">保密</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="手机号" prop="phoneNum">
        <el-input v-model="registerForm.phoneNum" placeholder="请输入手机号"></el-input>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="registerForm.email" placeholder="请输入邮箱"></el-input>
      </el-form-item>
      <el-form-item label="生日" prop="birth">
        <el-date-picker
          v-model="registerForm.birth"
          type="date"
          style="width: 100%"
          placeholder="请选择出生年月"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="签名" prop="introduction">
        <el-input
          type="textarea"
          v-model="registerForm.introduction"
          placeholder="个性签名"
        ></el-input>
      </el-form-item>
      <el-form-item label="地区" prop="location">
        <el-select v-model="registerForm.location" placeholder="请选择地区">
          <el-option v-for="item in AREA" :key="item.value" :label="item.label" :value="item.value">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item class="sign-btn">
        <el-button type="primary" @click="handleSignUp()">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, getCurrentInstance } from 'vue'
import mixin from '@/mixins/mixin'
import YinLoginLogo from '@/components/layouts/YinLoginLogo.vue'
import { HttpManager, ResponseBody } from '@/api'
import { AREA, RouterName, NavName, SignInRules } from '@/enums'

export default defineComponent({
  components: {
    'yin-login-logo': YinLoginLogo
  },
  setup() {
    const { proxy } = getCurrentInstance()
    const { changeIndex, routerManager } = mixin()
    const registerForm = reactive({
      username: '',
      password: '',
      sex: '',
      phoneNum: '',
      email: '',
      birth: new Date(),
      introduction: '',
      location: ''
    })

    async function handleSignUp() {
      let canRun = true
      ;(proxy.$refs['signUpForm'] as any).validate((valid) => {
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
        const sex = registerForm.sex
        const phoneNum = registerForm.phoneNum
        const email = registerForm.email
        const birth = registerForm.birth
        const introduction = registerForm.introduction
        const location = registerForm.location
        const result = (await HttpManager.signUp({
          username,
          password,
          sex,
          phoneNum,
          email,
          birth,
          introduction,
          location
        })) as ResponseBody
        ;(proxy as any).$message({
          message: result.message,
          type: result.type
        })
        if (result.success) {
          changeIndex(NavName.SignIn)
          routerManager(RouterName.SignIn, { path: RouterName.SignIn })
        }
      } catch (error) {
        console.error(error)
      }
    }
    return {
      SignInRules,
      AREA,
      registerForm,
      handleSignUp
    }
  }
})
</script>
