<template>
  <yin-header></yin-header>
  <yin-aside></yin-aside>
  <div class="content-box" :class="{ 'content-collapse': collapse }">
    <router-view></router-view>
  </div>
  <yin-audio></yin-audio>
</template>

<script lang="ts" setup>
import { ref } from "vue";
import YinHeader from "@/components/layouts/YinHeader.vue";
import YinAside from "@/components/layouts/YinAside.vue";
import YinAudio from "@/components/layouts/YinAudio.vue";
import emitter from "@/utils/emitter";

const collapse = ref(false);
emitter.on("collapse", (msg) => {
  collapse.value = msg as boolean;
});
</script>