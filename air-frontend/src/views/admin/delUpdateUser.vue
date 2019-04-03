<!--  -->
<template>
  <div>
    <el-row>
      <el-col>
        <el-table :data="tableData"
                  border
                  style="width: 100%">
          <el-table-column fixed
                           prop="id"
                           label="ID">
          </el-table-column>
          <el-table-column prop="username"
                           label="用户名">
          </el-table-column>
          <el-table-column prop="password"
                           label="密码">
          </el-table-column>
          <el-table-column prop="phone"
                           label="手机号">
          </el-table-column>
          <el-table-column prop="name"
                           label="姓名">
          </el-table-column>
          <el-table-column prop="idcard"
                           label="身份证">
          </el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button @click="del(scope.row)"
                         type="text"
                         size="small">删除</el-button>
              <el-button @click="update(scope.row)"
                         type="text"
                         slot="reference"
                         size="small">编辑</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-col>
    </el-row>
    <el-dialog title="编辑用户"
               :visible.sync="dialogFormVisible"
               append-to-body
               width="30%">
      <el-form label-position="left"
               label-width="80px"
               :model="formLabelAlign">
        <el-form-item label="密码">
          <el-input v-model="formLabelAlign.password"
                    show-password></el-input>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input v-model="formLabelAlign.name"></el-input>
        </el-form-item>
        <el-form-item label="身份证">
          <el-input v-model="formLabelAlign.idcard"></el-input>
        </el-form-item>
        <el-form-item label="手机号">
          <el-input v-model="formLabelAlign.phone"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary"
                     @click="confirm">确定</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogFormVisible: false,
      tableData: [],
      formLabelAlign: {}
    };
  },
  methods: {
    async del(row) {
      let res = await this.axios.post("/api/delUserById", { id: row.id });
      if (res.data.code === 0) {
        this.$message(res.data.msg);
        let tableData = await this.axios.post("/api/selectUser");
        this.tableData = tableData.data.data;
      }
    },
    update(row) {
      this.formLabelAlign = row;
      this.dialogFormVisible = true;
    },
    async confirm() {
      let res = await this.axios.post("/api/updateUser", this.formLabelAlign);
      if (res.data.code === 0) {
        this.$message(res.data.msg);
        let tableData = await this.axios.post("/api/selectUser");
        this.tableData = tableData.data.data;
      }
    }
  },
  async mounted() {
    let tableData = await this.axios.post("/api/selectUser");
    this.tableData = tableData.data.data;
  }
};
</script>

<style lang='less' scoped>
</style>