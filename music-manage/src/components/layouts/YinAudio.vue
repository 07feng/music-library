<template>
  <audio
    controls="controls"
    preload="true"
    v-if="url"
    :ref="player"
    @canplay="startPlay"
    @ended="ended"
  ></audio>
</template>

<script lang="ts">
import { computed, defineComponent, getCurrentInstance, ref, watch } from 'vue'
import { useStore } from 'vuex'

export default defineComponent({
  setup() {
    const { proxy } = getCurrentInstance()
    const store = useStore()
    const divRef = ref<HTMLAudioElement>()
    const player = (el) => {
      divRef.value = el
    }
    const url = computed(() => store.getters.url)
    const isPlay = computed(() => store.getters.isPlay)
    watch(isPlay, () => {
      togglePlay()
    })

    function togglePlay() {
      isPlay.value ? divRef.value?.play() : divRef.value?.pause()
    }

    function startPlay() {
      divRef.value?.play()
    }

    function ended() {
      proxy.$store.commit('setIsPlay', false)
    }
    return {
      url,
      player,
      isPlay,
      startPlay,
      ended
    }
  }
})
</script>

<style scoped>
audio {
  display: none;
}
</style>
