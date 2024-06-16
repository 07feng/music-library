<template>
  <!-- 图标 -->
  <div class="yin-header">
    <div class="header-logo">
      <yin-icon :icon="iconList.ERJI"></yin-icon>
      <span>{{ musicName }}</span>
    </div>
    <yin-header-nav
      class="yin-header-nav"
      :styleList="headerNavList"
      :active-name="activeNavName"
      @click="goPage"
    ></yin-header-nav>
    <!-- 搜索框 -->
    <div class="header-search">
      <el-input
        v-model="keywords"
        placeholder="搜索"
        :prefix-icon="Search"
        @keyup.enter="goSearch"
      ></el-input>
    </div>
    <yin-header-nav
      v-if="!token"
      :style-list="signList"
      :active-name="activeNavName"
      @click="goPage"
    ></yin-header-nav>
    <el-dropdown class="user-wrap" v-if="token" trigger="click">
      <el-image class="user" :src="HttpManager.attachImageUrl(userPic)" fit="contain" />
      <template>
        <el-dropdown-menu>
          <el-dropdown-item
            v-for="(item, index) in menuList"
            :key="index"
            @click.stop="getMenuList(item.path)"
            >{{ item.name }}</el-dropdown-item
          >
        </el-dropdown-menu>
      </template>
    </el-dropdown>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, reactive, getCurrentInstance, computed } from 'vue'
import { Search } from '@element-plus/icons-vue'
import { useStore } from 'vuex'
import YinIcon from '@/components/layouts/YinIcon.vue'
import YinHeaderNav from '@/components/layouts/YinHeaderNav.vue'
import mixin from '@/mixins/mixin'
import { HEADERNAVLIST, SIGNLIST, MENULIST, Icon, MUSICNAME, RouterName, NavName } from '@/enums'
import { HttpManager } from '@/api'

export default defineComponent({
  components: {
    'yin-icon': YinIcon,
    'yin-header-nav': YinHeaderNav
  },
  setup() {
    const { proxy } = getCurrentInstance()
    const { changeIndex, routerManager } = mixin()
    const store = useStore()
    const iconList = reactive({
      ERJI: Icon.ERJI
    })
    const signList = ref(SIGNLIST)
    const menuList = ref(MENULIST)
    const musicName = ref('')
    const headerNavList = ref(HEADERNAVLIST)
    const activeNavName = computed(() => {
      return store.getters.activeNavName
    })
    const keywords = ref('')
    const token = computed(() => {
      return store.getters.token
    })
    const userPic = computed(() => {
      return store.getters.userPic
    })

    function goPage(path, name) {
      if (!path && !name) {
        changeIndex(NavName.Home)
        routerManager(RouterName.Home, { path: RouterName.Home })
      } else {
        changeIndex(name)
        routerManager(path, { path })
      }
    }
    function goSearch() {
      if (keywords.value !== '') {
        proxy.$store.commit('setSearchWord', keywords.value)
        changeIndex(NavName.Home)
        routerManager(RouterName.Search, {
          path: RouterName.Search,
          query: { keywords: keywords.value }
        })
      } else {
        (proxy as any).$message({
          message: '搜索内容不能为空',
          type: 'error'
        })
      }
    }
    function getMenuList(path) {
      if (path == RouterName.SignOut) {
        proxy.$store.commit('setToken', false)
        changeIndex(NavName.Home)
        routerManager(RouterName.Home, { path: RouterName.Home })
      } else {
        routerManager(path, { path })
      }
    }
    return {
      musicName,
      headerNavList,
      iconList,
      signList,
      menuList,
      activeNavName,
      token,
      keywords,
      userPic,
      Search,
      HttpManager,
      goPage,
      goSearch,
      getMenuList
    }
  }
})
</script>
