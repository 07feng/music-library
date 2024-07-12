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
        <img src="/src/assets/images/user.jpg" />
      </div>
      <el-dropdown class="user-name" trigger="click" @command="handleCommand">
        <span class="el-dropdown-link">
          {{ username }}
          <i class="el-icon-caret-bottom"></i>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item command="loginOut">退出登录</el-dropdown-item>
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
import { computed, defineComponent, ref } from 'vue'
import { useStore } from 'vuex'

export default defineComponent({
  components: {
    Expand,
    Fold
  },
  setup() {
    const store = useStore()
    const collapse = ref(true)
    const { routerManager } = mixin()
    const musicName = ref(MUSICNAME)
    const username = ref('admin')
    const userPic = computed(() => store.getters.userPic)

    function collapseChage() {
      collapse.value = !collapse.value
      emitter.emit('collapse', collapse.value)
    }

    function handleCommand(command?: any) {
      if (command == 'loginOut') {
        routerManager(RouterName.Login, { path: RouterName.Login })
      }
    }

    return {
      userPic,
      musicName,
      username,
      collapse,
      collapseChage,
      handleCommand
    }
  }
})
</script>

<style scoped>
.header {
  position: absolute;
  z-index: 100;
  width: 100%;
  height: 60px;
  display: flex;
  align-items: center;
  font-size: 20px;
  color: #2c3e50;
  background: #ffff;
  box-shadow: 0px 0px 8px 2px rgba(0, 0, 0, 0.3);
}

.collapse-btn {
  display: flex;
  padding: 0 21px;
  cursor: pointer;
}

.header .logo {
  width: 250px;
  font-weight: bold;
}

.header-right {
  position: absolute;
  right: 0;
  padding-right: 30px;
}

.header-user-con {
  display: flex;
  align-items: center;
}

.user-name {
  margin-left: 10px;
}

.user-avator img {
  display: block;
  width: 40px;
  height: 40px;
  border-radius: 50%;
}

.el-dropdown-link {
  cursor: pointer;
}

.el-dropdown-menu__item {
  text-align: center;
}
</style>
