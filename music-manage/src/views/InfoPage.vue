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
      </el-card>
    </el-col>
    <el-col :span="6">
      <el-card shadow="hover" :body-style="{ padding: '0px' }">
        <div class="card-content">
          <div class="card-left">
            <el-icon><headset /></el-icon>
          </div>
          <div class="card-right">
            <div class="card-num">{{ songCount }}</div>
            <div>歌曲数量</div>
          </div>
        </div>
      </el-card>
    </el-col>
    <el-col :span="6">
      <el-card shadow="hover" :body-style="{ padding: '0px' }">
        <div class="card-content">
          <div class="card-left">
            <el-icon><headset /></el-icon>
          </div>
          <div class="card-right">
            <div class="card-num">{{ singerCount }}</div>
            <div>歌手数量</div>
          </div>
        </div>
      </el-card>
    </el-col>
    <el-col :span="6">
      <el-card shadow="hover" :body-style="{ padding: '0px' }">
        <div class="card-content">
          <div class="card-left">
            <el-icon><headset /></el-icon>
          </div>
          <div class="card-right">
            <div class="card-num">{{ songListCount }}</div>
            <div>歌单数量</div>
          </div>
        </div>
      </el-card>
    </el-col>
  </el-row>
  <el-row :gutter="20">
    <el-col :span="12" :offset="0">
      <h3>用户性别比例</h3>
      <el-card class="cav-info" shadow="hover" :body-style="{ padding: '0px' }" id="userSex">
      </el-card>
    </el-col>
    <el-col :span="12" :offset="0">
      <h3>歌曲类型</h3>
      <el-card class="cav-info" shadow="hover" :body-style="{ padding: '0px' }" id="songStyle">
      </el-card>
    </el-col>
  </el-row>
  <el-row :gutter="20">
    <el-col :span="12" :offset="0">
      <h3>歌手性别比例</h3>
      <el-card class="cav-info" shadow="hover" :body-style="{ padding: '0px' }" id="singerSex">
      </el-card>
    </el-col>
    <el-col :span="12" :offset="0">
      <h3>歌手国籍</h3>
      <el-card class="cav-info" shadow="hover" :body-style="{ padding: '0px' }" id="singerCountry">
      </el-card>
    </el-col>
  </el-row>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'
import { User, Headset } from '@element-plus/icons-vue'
import * as echarts from 'echarts'
import { HttpManager, type ResponseBody } from '@/api'
import type { XAXisOption } from 'echarts/types/dist/shared'
import type { AxisBaseOptionCommon } from 'echarts/types/src/coord/axisCommonTypes.js'
const userCount = ref(0)
const songCount = ref(0)
const singerCount = ref(0)
const songListCount = ref(0)
const userSex = reactive({
  series: [
    {
      type: 'pie',
      data: [
        {
          value: 0,
          name: '男'
        },
        {
          value: 0,
          name: '女'
        }
      ]
    }
  ]
})
const songStyle = reactive({
  xAxis: {
    type: 'category',
    data: ['华语', '粤语', '欧美', '日韩', 'BGM', '轻音乐', '乐器']
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      data: [0, 0, 0, 0, 0, 0, 0],
      type: 'bar',
      barWidth: '20%'
    }
  ]
})
const singerSex = reactive({
  series: [
    {
      type: 'pie',
      data: [
        {
          value: 0,
          name: '男'
        },
        {
          value: 0,
          name: '女'
        }
      ]
    }
  ]
})
let singerCountry = reactive({
  xAxis: [
    {
      type: 'category',
      data: ['中国', '韩国', '意大利', '新加坡', '美国', '马来西亚', '西班牙', '日本'],
      axisLabel: {}
    }
  ],
  yAxis: {
    type: 'value'
  },
  series: [
    {
      data: [0, 0, 0, 0, 0, 0, 0, 0],
      type: 'bar',
      barWidth: '20%'
    }
  ]
})

HttpManager.singerSexRadio().then((res) => {
  const result = res as ResponseBody
  const chart = echarts.init(document.getElementById('singerSex'))
  chart.setOption(result.data)
})

HttpManager.singerCountryStatistics().then((res) => {
  const result = res as ResponseBody
  singerCountry = result.data
  singerCountry.xAxis[0].axisLabel = { interval: 0, rotate: 60 }
  const chart = echarts.init(document.getElementById('singerCountry'))
  chart.setOption(singerCountry)
})
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
