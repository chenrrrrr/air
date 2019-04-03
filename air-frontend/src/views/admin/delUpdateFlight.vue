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
          <el-table-column prop="ttime"
                           :formatter="formatterTtime"
                           label="航班日期">
          </el-table-column>
          <el-table-column prop="no"
                           label="航班号">
          </el-table-column>
          <el-table-column prop="company"
                           label="航空公司">
          </el-table-column>
          <el-table-column prop="planemodel"
                           label="机型">
          </el-table-column>
          <el-table-column prop="destination"
                           label="目的地">
          </el-table-column>
          <el-table-column prop="plantime"
                           label="计划起飞时间">
          </el-table-column>
          <el-table-column prop="tno"
                           label="航站楼">
          </el-table-column>
          <el-table-column prop="port"
                           label="登机口">
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
    <el-dialog title="编辑航班"
               :visible.sync="dialogFormVisible"
               append-to-body
               width="50%">
      <el-form label-position="left"
               label-width="120px"
               ref="flight"
               :model="flight">
        <el-form-item label="航班编号"
                      prop="no"
                      :rules="{ required: true, message: '不能为空', trigger: 'blur' }">
          <el-input v-model="flight.no"></el-input>
        </el-form-item>
        <el-form-item label="航班日期"
                      prop="ttime"
                      :rules="{ required: true, message: '不能为空', trigger: 'blur' }">
          <el-date-picker v-model="flight.ttime"
                          type="date"
                          placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="航空公司"
                      prop="company"
                      :rules="{ required: true, message: '不能为空', trigger: 'blur' }">
          <el-input v-model="flight.company"></el-input>
        </el-form-item>
        <el-form-item label="机型"
                      prop="planemodel"
                      :rules="{ required: true, message: '不能为空', trigger: 'blur' }">
          <el-input v-model="flight.planemodel"></el-input>
        </el-form-item>
        <el-form-item label="目的地"
                      prop="destination"
                      :rules="{ required: true, message: '不能为空', trigger: 'blur' }">
          <el-input v-model="flight.destination"></el-input>
        </el-form-item>
        <el-form-item label="计划起飞时间"
                      prop="plantime"
                      :rules="{ required: true, message: '不能为空', trigger: 'blur' }">
          <el-time-select :picker-options="{ start: '08:30', step: '00:15', end: '18:30' }"
                          v-model="flight.plantime"
                          placeholder="计划起飞时间">
          </el-time-select>
        </el-form-item>
        <el-form-item label="航站楼"
                      prop="tno"
                      :rules="{ required: true, message: '不能为空', trigger: 'blur' }">
          <el-input v-model="flight.tno"></el-input>
        </el-form-item>
        <el-form-item label="登机口"
                      prop="port"
                      :rules="{ required: true, message: '不能为空', trigger: 'blur' }">
          <el-input v-model="flight.port"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary"
                     @click="confirm('flight')">确定</el-button>
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
      flight: {
        no: "",
        ttime: "",
        company: "",
        planemodel: "",
        destination: "",
        plantime: "",
        tno: "",
        port: ""
      }
    };
  },
  methods: {
    formatterTtime(row, column) {
      return (
        row.ttime.split("T")[0].split("-")[0] +
        "年" +
        row.ttime.split("T")[0].split("-")[1] +
        "月" +
        row.ttime.split("T")[0].split("-")[2] +
        "日"
      );
    },
    async del(row) {
      let res = await this.axios.post("/api/delFlightById", { id: row.id });
      if (res.data.code === 0) {
        this.$message(res.data.msg);
        let tableData = await this.axios.post("/api/selectFlight");
        this.tableData = tableData.data.data;
      }
    },
    update(row) {
      this.flight = row;
      this.dialogFormVisible = true;
    },
    async confirm() {
      let res = await this.axios.post("/api/updateFlight", this.flight);
      if (res.data.code === 0) {
        this.$message(res.data.msg);
        let tableData = await this.axios.post("/api/selectFlight");
        this.tableData = tableData.data.data;
      }
    }
  },
  async mounted() {
    let tableData = await this.axios.post("/api/selectFlight");
    this.tableData = tableData.data.data;
  }
};
</script>

<style lang='less' scoped>
</style>