<template>
  <transition>
    <div class="yin-current-play" v-if="showAside">
      <h2 class="title">当前播放</h2>
      <div class="control">共 {{ (currentPlayList && currentPlayList.length) || 0 }}</div>
      <ul class="menu">
        <li
          v-for="(item, index) in currentPlayList"
          :class="{ 'is-play': songId === item.id }"
          :key="index"
          @click="
            playMusic({
              id: item.id,
              url: item.url,
              pic: item.pic,
              index: item.index,
              name: item.name,
              lyric: item.lyric,
              currentSongList: item.currentSongList
            })
          "
        >
          {{ getSongTitle(item.name) }}
        </li>
      </ul>
    </div>
  </transition>
</template>

<script lang="ts">
import mixin from '@/mixins/mixin'
import { computed, defineComponent, getCurrentInstance, onMounted } from 'vue'
import { useStore } from 'vuex'

export default defineComponent({
  setup() {
    const { proxy } = getCurrentInstance()
    const store = useStore()
    const { getSongTitle, playMusic } = mixin()

    const songId = computed(() => {
      return store.getters.songId
    })
    const currentPlayList = computed(() => {
      return store.getters.currentPlayList
    })
    const showAside = computed(() => {
      return store.getters.showAside
    })

    onMounted(() => {
      document.addEventListener(
        'click',
        () => {
          proxy.$store.commit('setShowAside', false)
        },
        true
      )
    })
    return {
      songId,
      currentPlayList,
      showAside,
      getSongTitle,
      playMusic
    }
  }
})
</script>
