<template>
  <div id="app">
    <el-row type="flex"
            justify="center"
            style="padding-top:100px">
      <el-col :span="6">
        <el-tabs v-model="activeName"
                 type="border-card"
                 @tab-click="handleClick">
          <el-tab-pane label="登录"
                       name="login">
            <el-row style="padding-bottom:10px">
              <el-input v-model="username"
                        placeholder="请输入用户名"></el-input>
            </el-row>
            <el-row style="padding-bottom:10px">
              <el-input v-model="password"
                        placeholder="请输入密码"
                        show-password></el-input>
            </el-row>
            <el-row type="flex"
                    justify="center">
              <el-button type="primary"
                         @click="handleLogin">登入</el-button>
            </el-row>
          </el-tab-pane>
          <el-tab-pane label="注册"
                       name="register">
            <el-row style="padding-bottom:10px">
              <el-input v-model="rusername"
                        placeholder="请输入用户名"></el-input>
            </el-row>
            <el-row style="padding-bottom:10px">
              <el-input v-model="rpassword"
                        placeholder="请输入密码"
                        show-password></el-input>
            </el-row>
            <el-row style="padding-bottom:10px">
              <el-input v-model="rphone"
                        placeholder="请输入手机号"></el-input>
            </el-row>
            <el-row style="padding-bottom:10px">
              <el-input v-model="ridcard"
                        placeholder="身份证号"></el-input>
            </el-row>
            <el-row style="padding-bottom:10px">
              <el-input v-model="rname"
                        placeholder="请输入姓名"></el-input>
            </el-row>
            <el-row type="flex"
                    justify="center">
              <el-button type="primary"
                         @click="handleRegister">注册</el-button>
            </el-row>
          </el-tab-pane>
        </el-tabs>
      </el-col>
    </el-row>
    <router-view />
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
    return {
      activeName: "login",
      username: "",
      password: "",
      rusername: "",
      rpassword: "",
      rname: "",
      rphone: "",
      ridcard: ""
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab);
    },
    handleRegister() {
      if (
        this.rusername === "" ||
        this.rpassword === "" ||
        this.rname === "" ||
        this.rphone === "" ||
        this.ridcard === ""
      ) {
        return;
      }
      this.axios
        .post("/api/register", {
          username: this.rusername,
          password: this.rpassword,
          name: this.rname,
          phone: this.rphone,
          idcard: this.ridcard
        })
        .then(res => {
          if (res.data.code === 0) {
            this.$notify({
              title: "通知",
              message: res.data.msg,
              type: "success"
            });
            this.activeName = "login";
          } else {
            this.$notify({
              title: "通知",
              message: res.data.msg,
              type: "fail"
            });
          }
        });
    },
    handleLogin() {
      if (this.username !== "" || this.password !== "") {
        this.axios
          .post("/api/login", {
            username: this.username,
            password: this.password
          })
          .then(res => {
            if (res.data.code === 0) {
              // 身份
              let flag = res.data.data.role === 0 ? "user" : "admin";
              localStorage.setItem("flag", flag);
              localStorage.setItem("userid", res.data.data.id);
              this.$router.replace({ path: "/" + flag });
            } else if (res.data.code === 1) {
              this.$notify({
                title: "通知",
                message: res.data.msg,
                type: "fail"
              });
            } else {
              this.$notify({
                title: "通知",
                message: res.data.msg,
                type: "fail"
              });
            }
          });
      } else {
        this.$notify({
          title: "通知",
          message: "请输入用户名和密码",
          type: "fail"
        });
      }
    }
  }
};
</script>
