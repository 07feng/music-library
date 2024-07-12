<template>
  <el-row :gutter="20">
    <el-col :span="6">
      <el-card shadow="hover" :body-style="{ padding: '0px' }">
        <div class="card-content">
          <div class="card-left">
            <el-icon><user /></el-icon>
          </div>
          <div class="card-right">
            <div class="card-num">{{ userCount }}</div>
            <div>用户总数</div>
          </div>
        </div>
        <!-- card body -->
      </el-card>
    </el-col>
  </el-row>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import { User } from '@element-plus/icons-vue'
const userCount = ref(0)
</script>

<style scoped>
.card-content {
  display: flex;
  align-items: center;
  justify-content: space-around;
  height: 100px;
  padding-left: 20%;
  text-align: center;
}

.card-left {
  display: flex;
  font-size: 3rem;
}

.card-right {
  flex: 1;
  font-size: 14px;
}

.card-num {
  font-size: 30px;
  font-weight: bold;
}

h3 {
  margin: 10px 0;
  text-align: center;
}
.cav-info {
  border-radius: 6px;
  overflow: hidden;
  height: 250px;
  background-color: white;
}
</style>
