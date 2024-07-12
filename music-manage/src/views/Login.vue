<template>
  <div class="login-container">
    <div class="title">{{ musicName }}</div>
    <div class="login">
      <el-form :model="ruleForm" :rules="rules">
        <el-form-item prop="userName">
          <el-input v-model="ruleForm.userName" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input
            type="password"
            v-model="ruleForm.password"
            placeholder="请输入密码"
            @keyup.enter="submitForm"
          ></el-input>
        </el-form-item>

        <el-form-item>
          <el-button class="login-btn" type="primary" @click="submitForm">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script lang="ts">
import { HttpManager, type ResponseBody } from '@/api'
import { MUSICNAME } from '@/enums/music-name'
import { RouterName } from '@/enums/router-name'
import mixin from '@/mixins/mixin'
import { getCurrentInstance, reactive, ref, defineComponent } from 'vue'

export default defineComponent({
  setup() {
    const { proxy } = getCurrentInstance()
    const { routerManager } = mixin()
    const musicName = ref(MUSICNAME)
    const ruleForm = reactive({
      userName: '',
      password: ''
    })
    const rules = reactive({
      username: [{ require: true, message: '请输入用户名', trigger: 'blur' }],
      password: [{ require: true, message: '请输入密码', trigger: 'blur' }]
    })

    async function submitForm() {
      let userName = ruleForm.userName
      let password = ruleForm.password
      const result = (await HttpManager.login({ userName, password })) as ResponseBody
      if (result.code == '200') {
        proxy.$message({
          message: result.message,
          type: 'sucess'
        })
        routerManager(RouterName.Info, { path: RouterName.Info })
      } else {
        proxy.$message({
          message: result.message,
          type: 'warning'
        })
      }
    }

    return {
      musicName,
      ruleForm,
      rules,
      submitForm
    }
  }
})
</script>

<style scoped>
.login-container {
  position: relative;
  background: url('../assets/images/background.jpg');
  background-attachment: fixed;
  background-position: center;
  background-size: cover;
  width: 100%;
  height: 100%;
}

.title {
  position: absolute;
  top: 50%;
  width: 100%;
  margin-top: -230px;
  text-align: center;
  font-size: 30px;
  font-weight: 600;
  color: #fff;
}

.login {
  position: absolute;
  left: 50%;
  top: 50%;
  width: 300px;
  margin: -150px 0 0 -190px;
  padding: 40px;
  border-radius: 5px;
  background: #fff;
}

.login-btn {
  width: 100%;
}
</style>
