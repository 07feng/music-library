<template>
  <div>
    <el-dialog title="提示" v-model="centerDialogVisable" width="300px" center>
      <div class="del-dialog-cnt" align="center">删除不可恢复，是否确定删除？</div>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="cancelRow">取消</el-button>
          <el-button type="primary" @click="confirm">确定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script lang="ts">
import { defineComponent, getCurrentInstance, toRefs, watch, ref } from 'vue'
export default defineComponent({
  props: {
    delVisable: Boolean
  },
  emits: ['cancelRow', 'confirm'],
  setup(props) {
    const { proxy } = getCurrentInstance()
    const { delVisable } = toRefs(props)
    const centerDialogVisable = ref(delVisable.value)

    watch(delVisable, (value) => {
      centerDialogVisable.value = value
    })

    function cancelRow() {
      proxy.$emit('cancelRow', false)
    }

    function confirm() {
      proxy.emit('confirm', null)
    }

    return {
      centerDialogVisable,
      cancelRow,
      confirm
    }
  }
})
</script>
