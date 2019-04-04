<!--  -->
<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="10">
        <el-form label-position="left"
                 label-width="120px"
                 ref="flightRoute"
                 :model="flightRoute">
          <el-form-item label="航班编号"
                        prop="flightid"
                        :rules="{ required: true, message: '不能为空', trigger: 'blur' }">
            <el-select v-model="flightRoute.flightid"
                       placeholder="请选择航班">
              <el-option v-for="item in flights"
                         :key="item.id"
                         :label="item.planemodel+'-'+item.plantime+'-'+item.destination"
                         :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="时刻"
                        prop="time"
                        :rules="{ required: true, message: '不能为空', trigger: 'blur' }">
            <el-time-select :picker-options="{ start: '00:00', step: '00:15', end: '24:00' }"
                            v-model="flightRoute.time"
                            placeholder="时刻">
            </el-time-select>
          </el-form-item>
          <el-form-item label="天气"
                        prop="weather"
                        :rules="{ required: true, message: '不能为空', trigger: 'blur' }">
            <el-select v-model="flightRoute.weather"
                       placeholder="请选择天气">
              <el-option v-for="item in weatherList"
                         :key="item"
                         :label="item"
                         :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="经纬度"
                        :rules="{ required: true, message: '不能为空', trigger: 'blur' }">
            <el-row :gutter="20">
              <el-col :span="6"
                      style="padding-left:0">
                <el-input v-model="flightRoute.jing"
                          placeholder="经度"></el-input>
              </el-col>
              <el-col :span="6">
                <el-input v-model="flightRoute.wei"
                          placeholder="纬度"></el-input>
              </el-col>
            </el-row>
          </el-form-item>
          <el-form-item label="沿途"
                        :rules="{ required: true, message: '不能为空', trigger: 'blur' }">
            <el-row :gutter="20">
              <el-col :span="6"
                      style="padding-left:0">
                <el-input v-model="flightRoute.height"
                          placeholder="高度"></el-input>
              </el-col>
              <el-col :span="6">
                <el-input v-model="flightRoute.city"
                          placeholder="城市"></el-input>
              </el-col>
            </el-row>
          </el-form-item>
          <el-form-item>
            <el-button type="primary"
                       @click="confirm('flightRoute')">添加</el-button>
          </el-form-item>
        </el-form>
      </el-col>
      <el-col :span="14">
        <el-table :data="tableData"
                  border
                  style="width: 100%">
          <el-table-column fixed
                           prop="id"
                           label="ID"
                           width="100">
          </el-table-column>
          <el-table-column prop="height"
                           label="高度/米"
                           width="120">
          </el-table-column>
          <el-table-column prop="jing"
                           label="经度"
                           width="120">
          </el-table-column>
          <el-table-column prop="wei"
                           label="纬度"
                           width="120">
          </el-table-column>
          <el-table-column prop="city"
                           label="城市"
                           width="200">
          </el-table-column>
          <el-table-column prop="weather"
                           label="天气"
                           width="120">
          </el-table-column>
          <el-table-column prop="time"
                           label="时刻"
                           width="120">
          </el-table-column>
          <el-table-column fixed="right"
                           label="操作"
                           width="100">
            <template slot-scope="scope">
              <el-button @click="del(scope.row)"
                         type="text"
                         size="small">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-col>
    </el-row>

  </div>
</template>

<script>
export default {
  watch: {
    flightRoute: {
      deep: true,
      handler: function(newVal, oldVal) {
        this.renderFlightRouteByFlightId(+newVal.flightid);
      }
    }
  },
  data() {
    return {
      tableData: [],
      weatherList: ["晴", "小雨", "大风", "中雨", "大雨"],
      flights: [],
      flightRoute: {
        flightid: "",
        time: "",
        weather: "",
        jing: "",
        wei: "",
        height: "",
        city: ""
      }
    };
  },
  methods: {
    async del(row) {
      let res = await this.axios.post("/api/delFlightRouteByFlightId", {
        id: row.id
      });
      if (res.data.code === 0) {
        this.renderFlightRouteByFlightId(+this.flightRoute.flightid);
      }
    },
    async renderFlightRouteByFlightId(id) {
      let res = await this.axios.post("/api/selectFlightRouteByFlightId", {
        flightid: id
      });
      if (res.data.code === 0) {
        this.tableData = res.data.data;
      }
    },
    async renderFlights() {
      let res = await this.axios.post("/api/selectFlight");
      if (res.data.code === 0) {
        this.flights = res.data.data;
      }
    },
    confirm(formName) {
      this.$refs[formName].validate(valid => {
        if (
          valid &&
          this.flightRoute.jing !== "" &&
          this.flightRoute.wei !== "" &&
          this.flightRoute.height !== "" &&
          this.flightRoute.city !== ""
        ) {
          this.axios.post("/api/addFlightRoute", this.flightRoute).then(res => {
            if (res.data.code === 0) {
              this.$message(res.data.msg);
              this.renderFlightRouteByFlightId(+this.flightRoute.flightid)
            }
          });
          console.log(this.flightRoute);
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    }
  },
  mounted() {
    this.renderFlights();
  }
};
</script>

<style lang='less' scoped>
</style>