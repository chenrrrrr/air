<!-- 管理 -->
<template>
  <el-container style="height:100%">
    <el-aside width="200px"
              height="100%">
      <el-menu default-active="1"
               class="el-menu-vertical-demo"
               style="height:100%">
        <el-menu-item>
          <span style="color:#409EFF">航班管理系统 - 管理员</span>
        </el-menu-item>

        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span>航班管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="1-1"
                          @click="addFlight">添加</el-menu-item>
            <el-menu-item index="1-2"
                          @click="delUpdateFlight">删除/修改</el-menu-item>
            <el-menu-item index="1-3"
                          @click="flightRouteConfig">设置时刻轨迹</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span>用户管理</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="1-1"
                          @click="delUpdateUser">修改/删除</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
        <el-menu-item index="3"
                      @click="destinationConfig">
          <i class="el-icon-date"></i>
          <span slot="title">航班目的地周边配置</span>
        </el-menu-item>
        <el-menu-item index="4"
                      @click="handleExit">
          <i class="el-icon-back"></i>
          <span slot="title">退出</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-main>
      <router-view />
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: "admin",
  data() {
    return {};
  },
  methods: {
    handleExit() {
      localStorage.removeItem("flag");
      localStorage.removeItem("userid");
      this.$router.push("/");
    },
    addFlight() {
      this.$router.push("/admin/addFlight");
    },
    delUpdateFlight() {
      this.$router.push("/admin/delUpdateFlight");
    },
    flightRouteConfig() {
      this.$router.push("/admin/flightRouteConfig");
    },
    delUpdateUser() {
      this.$router.push("/admin/delUpdateUser");
    },
    destinationConfig() {
      this.$router.push("/admin/destinationConfig");
    }
  }
};
</script>