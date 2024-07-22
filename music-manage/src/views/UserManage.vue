<template>
  <div class="container">
    <div class="handle-box">
      <el-button type="primary" @click="batchDelete">
        <el-icon><Delete /></el-icon>
        <span>批量删除</span>
      </el-button>
      <el-input v-model="searchKey" placeholder="用户名/手机号/邮箱"></el-input>
      <el-button type="primary" @click="getTableData">
        <el-icon><search /></el-icon>
        <span>搜索</span>
      </el-button>
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
          <el-button @click="getCollectPage(scope.row.id)">收藏</el-button>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="90" align="center">
        <template v-slot="scope">
          <el-button type="danger" @click="deleteRow(scope.row.id)">
            <el-icon><Delete /> </el-icon>
            <span>删除</span>
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="修改" width="90" align="center">
        <template v-slot="scope">
          <el-upload action="" :show-file-list="false">
            <el-button>更新头像</el-button>
          </el-upload>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      background
      size="small"
      class="pagination"
      :current-page="currentPage"
      @update:current-page="handleCurrentChange"
      @pre-click="handlePre"
      @next-click="handleNext"
      :page-size="pageSize"
      @update:page-size="handlePageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      :page-sizes="[10, 20, 50, 100]"
    >
    </el-pagination>
  </div>
  <yin-del-dialog
    :delVisible="delVisible"
    @confirm="confirm"
    @cancelRow="delVisible = $event"
  ></yin-del-dialog>
</template>

<script lang="ts">
import { HttpManager, type ResponseBody } from '@/api'
import { RouterName } from '@/enums/router-name'
import mixin from '@/mixins/mixin'
import { getBirth } from '@/utils'
import { ElMessage } from 'element-plus'
import { defineComponent, getCurrentInstance, ref, reactive } from 'vue'
import YinDelDialog from '@/components/dialog/YinDelDialog.vue'

export default defineComponent({
  components: {
    YinDelDialog
  },
  setup() {
    const { proxy } = getCurrentInstance()
    const { changeSex, routerManager } = mixin()

    const pageSize = ref(10)
    const currentPage = ref(1)
    const searchKey = ref('')
    const tableData = ref([])
    const total = ref(0)

    getTableData()

    async function getTableData() {
      HttpManager.getUserPageList(currentPage.value, pageSize.value, {
        searchKey: searchKey.value
      }).then((res) => {
        const result = res as ResponseBody
        tableData.value = result.data.list
        total.value = result.data.total
      })
    }

    //获取当前页
    function handleCurrentChange(val) {
      currentPage.value = val
      getTableData()
    }
    //切换分页大小
    function handlePageSize(val) {
      pageSize.value = val
      getTableData()
    }
    //上一页
    function handlePre(val) {
      currentPage.value = val
      getTableData()
    }
    //下一页
    function handleNext(val) {
      currentPage.value = val
      getTableData()
    }

    function getCollectPage(id) {
      const breadCrumbList = reactive([
        {
          path: RouterName.User,
          name: '用户管理'
        },
        {
          path: '',
          name: '收藏信息'
        }
      ])
      proxy.$store.commit('setBreadCrumbList', breadCrumbList)
      routerManager(RouterName.Collect, { path: RouterName.Collect, query: { id } })
    }

    const idx = ref(-1)
    const selectedUserList = ref([])
    const delVisible = ref(false)

    function deleteRow(val) {
      idx.value = val
      delVisible.value = true
    }

    function handleSelectionChange(val) {
      selectedUserList.value = val
    }

    function confirm() {
      HttpManager.deleteUserById(idx.value).then((res) => {
        const result = res as ResponseBody
        if (result.code == '200') {
          proxy.$message({
            message: '删除成功',
            type: 'sucess'
          })
          delVisible.value = false
          getTableData()
        } else {
          proxy.$message({
            message: result.message,
            type: 'error'
          })
        }
      })
    }

    function batchDelete() {
      let idList = selectedUserList.value
      if (idList == null || idList.length == 0) {
        ElMessage.warning('至少选择一个用户删除')
        return
      }
      let ids = idList.map((item) => item.id)
      HttpManager.batchDeleteUser(ids).then((res) => {
        const result = res as ResponseBody
        if (result.code == '200') {
          proxy.$message({
            message: '删除成功',
            type: 'sucess'
          })
          getTableData()
        } else {
          proxy.$message({
            message: result.message,
            type: 'error'
          })
        }
      })
    }
    return {
      tableData,
      currentPage,
      pageSize,
      searchKey,
      total,
      delVisible,
      getTableData,
      changeSex,
      getCollectPage,
      getBirth,
      handleCurrentChange,
      handleSelectionChange,
      handlePageSize,
      handlePre,
      handleNext,
      deleteRow,
      confirm,
      batchDelete
    }
  }
})
</script>
