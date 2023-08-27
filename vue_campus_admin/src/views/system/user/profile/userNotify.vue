<template>
  <el-form ref="form" :model="user" :rules="rules" label-width="80px">
    <el-form-item label="通知类型" prop="notifyType">
      <el-select v-model="user.notifyType" placeholder="请选择">
        <el-option
          v-for="item in notifyTypeOptions"
          :key="item.value"
          :label="item.label"
          :value="item.value"
        >
        </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="通知token" prop="notifyToken">
      <el-input v-model="user.notifyToken" maxlength="100" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" size="mini" @click="submit">保存</el-button>
      <el-button type="danger" size="mini" @click="close">关闭</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import { updateNotifySetting } from "@/api/system/user";

export default {
  props: {
    user: {
      type: Object
    }
  },
  data() {
    return {
      user: {
        notifyType: undefined,
        notifyToken: undefined
      },
      // 表单校验
      rules: {
      },
      notifyTypeOptions: [
        {
          value: 1,
          label: "pushPlus推送加（微信公众号）",
        },
        {
          value: 2,
          label: "Bark（IOS专用）",
        },
      ],
    };
  },
  methods: {
    submit() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          updateNotifySetting(this.user.notifyType,this.user.notifyToken).then(response => {
            this.$modal.msgSuccess("修改成功");
          });
        }
      });
    },
    close() {
      this.$tab.closePage();
    }
  }
};
</script>
