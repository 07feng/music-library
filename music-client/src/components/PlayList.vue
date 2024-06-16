<template>
  <div class="play-list">
    <div class="play-title"></div>
  </div>
</template>

<script lang="ts">
import { defineComponent, getCurrentInstance, toRefs } from 'vue'

import YinIcon from '@/components/layouts/YinIcon.vue'
import mixins from '@/mixins/mixin'

export default defineComponent({
  props: {
    title: String,
    playList: Array,
    path: String
  }
})
</script>
