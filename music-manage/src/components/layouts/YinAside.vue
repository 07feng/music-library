<template>
    <div class="sidebar">
        <el-menu class="sidebar-el-menu" default-active="2" background-color="#fff" active-text-color="#30a4fc" router
            :collapse="collapse">
            <el-menu-item index="info">
                <el-icon><pie-chart /></el-icon>
                <span>系统首页</span>
            </el-menu-item>
            <el-menu-item index="consumer">
                <el-icon>
                    <user />
                </el-icon>
                <span>用户管理</span>
            </el-menu-item>
            <el-menu-item index="singer">
                <el-icon>
                    <mic />
                </el-icon>
                <span>歌手管理</span>
            </el-menu-item>
            <el-menu-item index="songList">
                <el-icon>
                    <Document />
                </el-icon>
                <span>歌单管理</span>
            </el-menu-item>
        </el-menu>
    </div>
</template>

<script lang="ts" setup>
import { ref } from 'vuex';
import { PieChart, Mic, Document, User } from "@element-plus/icons-vue";
import emitter from "@/utils/emitter";

const collapse = ref(false);
emitter.on("collapse", (msg) => {
    collapse.value = msg as boolean
});
</script>