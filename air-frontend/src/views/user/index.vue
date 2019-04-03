<!-- 管理 -->
<template>
  <el-container style="height:100%">
    <el-aside width="200px"
              height="100%">
      <el-menu default-active="1"
               class="el-menu-vertical-demo"
               style="height:100%">
        <el-menu-item>
          <span style="color:#409EFF">航班管理系统 - 用户</span>
        </el-menu-item>
        <el-menu-item index="1"
                      @click="flightView">
          <i class="el-icon-date"></i>
          <span slot="title">航班查询(订票)</span>
        </el-menu-item>
        <el-menu-item index="2"
                      @click="myOrder">
          <i class="el-icon-date"></i>
          <span slot="title">我的订单</span>
        </el-menu-item>
        <el-submenu index="3">
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span>留言</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="1-1"
                          @click="addMsg">发布留言</el-menu-item>
            <el-menu-item index="1-2"
                          @click="viewMsg">查看留言</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
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
    flightView() {
      this.$router.push("/admin/flightView");
    },
    myOrder() {
      this.$router.push("/admin/myOrder");
    },
    addMsg() {
      this.$router.push("/admin/addMsg");
    },
    viewMsg() {
      this.$router.push("/admin/viewMsg");
    }
  }
};
</script>