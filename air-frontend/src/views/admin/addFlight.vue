<!--  -->
<template>
  <div>
    <el-row>
      <el-col>
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
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
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
    confirm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          this.axios.post("/api/addFlight", this.flight).then(res => {
            if (res.data.code === 0) {
              this.$message(res.data.msg);
            }
          });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    }
  }
};
</script>

<style lang='less' scoped>
</style>