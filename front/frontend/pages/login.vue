<template>
  <section class="login">
    <div class="container">
      <div class="row justify-content-center align-items-center">
        <div class="col-5">
          <form class="login-form">
            <h2>Sign in</h2>
            <div class="float-input">
              <input id="login-username" type="text" name="username" required>
              <span class="bar" />
              <label for="login-username">Username</label>
            </div>
            <div class="float-input">
              <input id="login-password" type="password" name="password" required>
              <span class="bar" />
              <label for="login-password">Password</label>
              <i class="see-password far fa-eye" />
            </div>
            <div class="sign-buttons">
              <button class="btn-left main">
                Sign in
              </button>
              <button type="button" class="link login-to-register signUp-signIn">
                Sign up
                <i class="fas fa-angle-double-right" />
              </button>
            </div>
          </form>
          <div class="register-super-form hidden">
            <h2>Create an account</h2>
            <div class="register-types">
              <label>
                <input type="radio" name="user-type" value="customer">
                Customer
              </label>
              <label>
                <input type="radio" name="user-type" value="restaurant">
                Restaurant
              </label>
            </div>
            <div class="sign-buttons continue-buttons">
              <button type="button" class="link register-to-login signUp-signIn">
                <i class="fas fa-angle-double-left" />
                Sign in
              </button>
              <button type="button" class="continue main disabled">
                Continue
                <i class="fas fa-angle-double-right" />
              </button>
            </div>
            <form class="register-form register-customer hidden">
              <div class="float-input">
                <input id="register-customer-username" type="text" name="username" required>
                <span class="bar" />
                <label for="register-customer-username">Username</label>
                <p class="validation-error">
                  This username already exists
                </p>
              </div>
              <div class="float-input">
                <input id="register-customer-password" type="password" name="password" required>
                <span class="bar" />
                <label for="register-customer-password">Password</label>
                <i class="see-password far fa-eye" />
                <p class="validation-error">
                  Password must contain at least 1 number
                </p>
              </div>
              <div class="float-input">
                <input id="register-customer-email" type="text" name="email" required>
                <span class="bar" />
                <label for="register-customer-email">Email</label>
                <p class="validation-error">
                  This email format is not supported
                </p>
              </div>
              <label class="register-form-conditions">
                <span>Accept our <a href="">conditions</a></span>
                <input type="checkbox" name="accept-conditions" required>
              </label>
              <div>
                <div class="sign-buttons">
                  <button type="button" class="link back">
                    <i class="fas fa-angle-double-left" />
                    Back
                  </button>
                  <button class="sign-up main">
                    Sign up
                  </button>
                </div>
              </div>
            </form>
            <form class="register-form register-restaurant hidden">
              <div class="account-info">
                <div class="float-input">
                  <input id="register-restaurant-username" type="text" name="username" required>
                  <span class="bar" />
                  <label for="register-restaurant-username">Username</label>
                  <p class="validation-error">
                    This username already exists
                  </p>
                </div>
                <div class="float-input">
                  <input id="register-restaurant-password" type="password" name="password" required>
                  <span class="bar" />
                  <label for="register-restaurant-password">Password</label>
                  <i class="see-password far fa-eye" />
                  <p class="validation-error">
                    Password must contain at least 1 number
                  </p>
                </div>
                <div class="float-input">
                  <input id="register-restaurant-email" type="text" name="email" required>
                  <span class="bar" />
                  <label for="register-restaurant-email">Email</label>
                  <p class="validation-error">
                    This email format is not supported
                  </p>
                </div>
                <div class="sign-buttons">
                  <button type="button" class="link back">
                    <i class="fas fa-angle-double-left" />
                    Back
                  </button>
                  <button type="button" class="continue main disabled">
                    Continue
                    <i class="fas fa-angle-double-right" />
                  </button>
                </div>
              </div>
              <div class="contact-info hidden">
                <div class="float-input">
                  <input id="register-restaurant-name" type="text" name="erstaurant-name" required>
                  <span class="bar" />
                  <label for="register-restaurant-name">Restaurant Name</label>
                </div>
                <div class="float-input">
                  <input id="register-restaurant-address" type="text" name="address" required>
                  <span class="bar" />
                  <label for="register-restaurant-address">Address</label>
                  <p class="validation-error" />
                </div>
                <div class="float-input">
                  <input id="register-restaurant-phone" type="tel" name="phone" required>
                  <span class="bar" />
                  <label for="register-restaurant-phone">Phone Number</label>
                  <p class="validation-error">
                    This phone format is not supported
                  </p>
                </div>
                <label class="register-form-conditions">
                  Accept our <a href="">conditions</a>
                  <input type="checkbox" name="accept-conditions" required>
                </label>
                <div class="sign-buttons">
                  <button type="button" class="link back">
                    <i class="fas fa-angle-double-left" />
                    Back
                  </button>
                  <button class="sign-up main">
                    Sign up
                  </button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
export default {

}
</script>
<style scoped>
.see-password {
    float: right;
    margin-top: -28px;
    margin-right: 5px;
    font-size: 18px;
    cursor: pointer;
    color: rgb(80, 80, 80);
    height: fit-content;
}
.see-password:hover {
    color: rgb(49, 49, 49);
}
.login .hidden {
    display:none;
    opacity: 0;
}
.login {
    margin-top: 15vh;
}
.login h2 {
    margin-bottom: 30px;
    padding-bottom: 5px;
    width: 100%;
    height: 50px;
    text-align: center;
}
.login-form, .register-super-form {
    position: relative;
    text-align: center;
    padding: 15px 30px 10px 30px;
    margin: 10px;
    min-height: 420px;
    border-radius: 5px;
}
.float-input label {
    font-size: 18px;
    color: #999;
    position: absolute;
    pointer-events: none;
    left: 5px;
    top: 10px;
    transition: 0.3s ease all;
}
.login input {
    display: block;
    font-size: 18px;
    margin-top: 5px;
    padding: 10px 10px 10px 5px;
    width: 100%;
    height: 40px;
    border: none;
    border-bottom: 1px solid rgb(70, 70, 70);
}
.float-input {
    margin-top: 60px;
    margin-bottom: 70px;
}
.login input:focus {
    outline: none;
}
.float-input input:focus ~ label, .float-input input:valid ~ label {
    top: -20px;
    font-size: 14px;
    color: orange;
}
.bar {
    position: relative;
    display: block;
    width: 300px;
}
.bar::after {
    content: '';
    height: 2px;
    width: 0;
    position: absolute;
    bottom: 0;
    left: 0;
    background-color: orange;
    transition: 1 ease all;
}
.float-input input:focus ~ .bar::after, .float-input input:valid ~ .bar::after {
    width: 100%;
}
.login button {
    width: 120px;
    height: 40px;
    border: none;
    outline: none;
    border-radius: 50px;
    bottom: 0;
    box-shadow: 0 0 8px grey;
    color: rgb(59, 59, 59);
}
.login button.main {
    background-color: orange;
}
.login button:hover {
    box-shadow: 0 0 8px 1px grey;
    color: rgb(99, 76, 51);
}
.login-to-register i, button.continue i {
    margin-left: 5px;
    margin-right: -5px;
}
.register-to-login i {
    margin-right: 5px;
    margin-left: -5px;
}
.login .link {
    color: rgb(194, 126, 0);
    text-decoration: none;
    cursor: pointer;
}
.login .link:hover {
    color: rgb(231, 150, 0);
}
.login-form p, .register-super-form p {
    position: absolute;
    right: 15px;
    bottom: 0;
    width: 100%;
    text-align: right;
    font-size: 15px;
}
.float-input {
    position: relative;
    top: 20%;
    margin-left: auto;
    margin-right: auto;
    width: 300px;
}
.register-super-form {
    padding-bottom: 60px;
}
.sign-buttons {
    display: flex;
    position: absolute;
    left: 0;
    bottom: 15px;
    justify-content: space-around;
    width: 100%;
    min-width: 300px;
}
.register-types {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
    align-items: center;
}
.register-types input {
    display: none;
}
.register-types label {
    cursor: pointer;
    width: 100%;
    height: 60px;
    padding-top: 16px;
    text-align: center;
    margin-bottom: 30px;
    margin-top: 20px;
    background-color: rgb(255, 224, 167);
    border-radius: 5px;
    box-shadow: 0 0 3px grey;
}
.register-types label:hover {
    box-shadow: 0 0 5px grey;
    background-color: rgb(255, 213, 134);
}
.register-types label.active {
    box-shadow: 0 0 3px 3px rgb(221, 162, 52);
    background-color: rgb(255, 213, 134);
}
button.disabled {
    opacity: 0.5;
    pointer-events: none;
}
label.disabled {
    opacity: 0.85;
}
.register-form-conditions {
    display: flex;
    justify-content: space-around;
    width: 100%;
    font-size: 14px;
}
.register-form-conditions input {
    width: 15px;
    margin-top: -8px;
}
p.validation-error {
    display: none;
    color: rgb(184, 12, 12);
    font-size: 12px;
    position: absolute;
    right: 5px;
    bottom: -52px;
    padding: 5px;
    background-color: rgba(44, 44, 44, 0.233);
    width: fit-content;
    border-radius: 5px;
}
p.validation-error::after {
    content: '';
    position: absolute;
    bottom: 100%;
    right: 10%;
    margin-left: -5px;
    border-width: 5px;
    border-style: solid;
    border-color: transparent transparent rgba(44, 44, 44, 0.233) transparent;
}
</style>
