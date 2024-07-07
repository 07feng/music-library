<template>
  <div class="header">
    <div class="collapse-btn" @click="collapseChage()">
      <el-icon v-if="!collapse">
        <expand />
        <fold />
      </el-icon>
      <el-icon v-else></el-icon>
    </div>
  </div>
  <div class="logo">{{ musicName }}</div>
  <div class="header-right">
    <div class="header-user-con">
      <div class="user-avator">
        <img :src="url" />
      </div>
      <el-dropdown class="user-name" trigger="click" @command="command">
        <span class="el-dropdown-link">
          {{ username }}
          <i class="el-icon-caret-bottom"></i>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item :command="loginOut">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script lang="ts">
import { MUSICNAME } from '@/enums/music-name'
import { RouterName } from '@/enums/router-name'
import mixin from '@/mixins/mixin'
import emitter from '@/utils/emitter'
import { Expand, Fold } from '@element-plus/icons-vue'
import { defineComponent, ref } from 'vue'
import { useStore } from 'vuex/types/index.js'

export default defineComponent({
  components: {
    Expand,
    Fold
  },
  setup(props, ctx) {
    const store = useStore(),
    const collapse = ref(true)
    const { routerManager } = mixin()
    const musicName = ref(MUSICNAME)
    const username = ref("admin")
    const userPic = computed(()=> store.getters.userPic)

    function collapseChage() {
      collapse.value = !collapse.value
      emitter.emit('collapse', collapse.value)
    }

    function handleCommand(command) {
      if (command == 'loginOut') {
        routerManager(RouterName.SignIn, { path: RouterName.SignIn })
      }
    }

    return {
      musicName,
      username,
      collapse,
      collapseChage,
      handleCommand,
    }
  }
})
</script>
