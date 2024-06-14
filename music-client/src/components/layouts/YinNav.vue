<template>
    <ul class="yin-nav">
        <li v-for="(item, index) in styleList" :key="index" :class="{ active: activeName === item.name }"
            @click="handleChangeView(item)">
            {{ item.name }}
        </li>
    </ul>
</template>

<script lang="ts">
import { defineComponent, getCurrentInstance } from 'vue';

export default defineComponent({
    props: {
        styleList: Array<any>,
        activeName: String
    },
    emits: ['click'],
    setup(props, { emit }) {
        const proxy = getCurrentInstance();
        function handleChangeView(val) {
            proxy.$emit('click', val);
        }
        return {
            handleChangeView
        }
    }
})
</script>

<style lang="scss" scoped>
@import url("../../assets/css/var.scss");

.yin-nav {
    width: 100%;

    li {
        line-height: 2rem;
        font-size: 1rem;
        color: $color-grey;
        border-bottom: none;
        cursor: pointer;
    }

    li.active {
        color: $color-black;
        font-weight: 600;
    }
}

@media screen and (min-width: $sm) {
    .yin-nav {
        li {
            margin: 0.3rem 0.4rem;
        }
    }
}
</style>