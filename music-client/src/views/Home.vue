<template>
  <!--轮播图-->
  <el-carousel
    class="swiper-container"
    v-if="swiperList.length"
    height="20vm"
    type="card"
    :interval="4000"
  >
    <el-carousel-item v-for="(item, index) in swiperList" :key="index">
      <img :src="HttpManager.attachImageUrl(item.pic)" />
    </el-carousel-item>
  </el-carousel>
  <!--热门歌单-->
  <play-list
    class="play-list-container"
    title="歌单"
    path="song-sheet-detail"
    :playList="songList"
  ></play-list>
  <!--热门歌手-->
  <play-list
    class="play-list-container"
    title="歌手"
    path="singer-detail"
    :playList="singerList"
  ></play-list>
</template>

<script lang="ts" setup>
import { HttpManager, ResponseBody } from '@/api'
import PlayList from '@/components/PlayList.vue'
import { NavName } from '@/enums'
import mixin from '@/mixins/mixin'
import { onMounted, ref } from 'vue'

const songList = ref([])
const singerList = ref([])
const swiperList = ref([])
const { changeIndex } = mixin()

try {
  HttpManager.getBannerList().then((res) => {
    swiperList.value = (res as ResponseBody).data.sort()
  })
  HttpManager.getSongList().then((res) => {
    songList.value = (res as ResponseBody).data.sort().slice(0, 10)
  })
  HttpManager.getAllSinger().then((res) => {
    singerList.value = (res as ResponseBody).data.sort().slice(0, 10)
  })
  onMounted(() => {
    changeIndex(NavName.Home)
  })
} catch (error) {
  console.error(error)
}
</script>


<style lang="scss" scoped>
@import "@/assets/css/var.scss";

/*轮播图*/
.swiper-container {
  width: 90%;
  margin: auto;
  padding-top: 20px;
  img {
    width: 100%;
  }
}

.swiper-container:deep(.el-carousel__indicators.el-carousel__indicators--outside) {
  display: inline-block;
  transform: translateX(30vw);
}

.el-slider__runway {
  background-color: $color-blue;
}
</style>
