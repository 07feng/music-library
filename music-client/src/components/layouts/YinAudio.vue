<template>
    <audio ></audio>
</template>

<script lang="ts">
import {defineComponent,ref,reactive,getCurrentInstance,computed,watch} from 'vue';
import {  useStore} from 'vuex';
import { HttpManager } from "@/api";

export default defineComponent({
    setup(){
        const proxy = getCurrentInstance();
        const store = useStore();
        const divRef = ref<HTMLAudioElement>();

        const player = (el)=> {
            divRef.value = el;
        }
        const muted = ref(true);
    }
})
</script>