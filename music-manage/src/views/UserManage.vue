<template>
  <div class="container">
    <div class="handle-box">
      <el-button @click="batchDelete">批量删除</el-button>
      <el-input v-model="searchKey" placeholder="选择用户"></el-input>
    </div>

    <el-table
      height="550px"
      border
      size="small"
      :data="tableData"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="40" align="center"></el-table-column>
      <el-table-column label="ID" prop="id" width="50" align="center"></el-table-column>
      <el-table-column label="用户头像" width="102" align="center">
        <template>
          <img src="" style="width: 80px" />
        </template>
      </el-table-column>
      <el-table-column label="用户名" prop="userName" width="80" align="center"></el-table-column>
      <el-table-column label="性别" width="50" align="center">
        <template v-slot="scope">
          <div>{{ changeSex(scope.row.sex) }}</div>
        </template>
      </el-table-column>
      <el-table-column
        label="手机号码"
        prop="phoneNum"
        width="120"
        align="center"
      ></el-table-column>
      <el-table-column label="邮箱" prop="email" width="120" align="center"></el-table-column>
      <el-table-column label="生日" width="80" align="center">
        <template v-slot="scope">
          <div>{{ getBirth(scope.row.birth) }}</div>
        </template>
      </el-table-column>
      <el-table-column label="签名" prop="introduction"></el-table-column>
      <el-table-column label="地区" prop="location" width="70" align="center"></el-table-column>
      <el-table-column label="收藏" width="90" align="center">
        <template v-slot="scope">
          <el-button @click="getCollection(scope.row.id)">收藏</el-button>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="90" align="center">
        <template v-slot="scope">
          <el-button type="danger" @click="deleteById(scope.row.id)"></el-button>
        </template>
      </el-table-column>
      <el-table-column label="修改" width="90" align="center">
        <template v-slot="scope">
          <el-upload
            action=""
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload"
          >
            <el-button>更新头像</el-button>
          </el-upload>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      class="pagination"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="tableData.length"
      background
    >
    </el-pagination>
  </div>
</template>

<script lang="ts">
import { HttpManager, type ResponseBody } from '@/api'
import mixin from '@/mixins/mixin'
import { defineComponent, getCurrentInstance, reactive, ref } from 'vue'

export default defineComponent({
  components: {},
  setup() {
    const { proxy } = getCurrentInstance()
    const { changeSex, routerManager } = mixin()

    const tableData = reactive({
      total: 0,
      list: []
    })
    const pageSize = 1
    const currentPage = 20
    const searchKey = ''

    getTableData()

    async function getTableData() {
      let pageNum = currentPage
      let size = pageSize
      let key = searchKey
      HttpManager.getUserPageList(pageNum, size, { key }).then((res) => {
        const result = res as ResponseBody
        tableData.list = result.data.list
        tableData.total = result.data.total
      })
    }

    return {
      tableData,
      currentPage,
      pageSize,
      searchKey,
      changeSex
    }
  }
})
</script>
