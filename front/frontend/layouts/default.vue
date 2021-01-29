<template>
  <section class="body">
    <section id="top" class="header">
      <div class="container">
        <div class="row justify-content-between align-items-center">
          <div class="public-logo col-2">
            <img src="img/logo-transparent.png" alt="MyApp Logo">
          </div>
          <div class="col-auto">
            <ul class="desktop-menu nav">
              <!-- check links -->
              <a class="nav-link" href="#explore">Explora</a>
              <a class="nav-link" href="#help">Ayuda</a>
              <a class="nav-link" href="login.html">Login/Register</a>
            </ul>
          </div>
          <div class="mobile-menu col-auto">
            <i class="fas fa-bars" />
          </div>
        </div>
      </div>
    </section>
    <Nuxt />
    <back-to-top-arrow />
  </section>
</template>
<script>
import BackToTopArrow from '~/components/BackToTopArrow.vue'
export default {
  components: {
    BackToTopArrow
  }
}
</script>
<style>
.header {
    box-sizing: border-box;
    position: absolute;
    width: 100vw;
    background-color: var(--hard-orange);
    padding: 10px 10px 10px 15px;
    z-index: 10;
}
.public-logo img {
    max-width: 100%;
}
.desktop-menu a {
    color: black;
    border-radius: 50px;
}
.desktop-menu a:hover {
    background-color: var(--light-orange);
}
.desktop-menu a:nth-last-child(1) {
    background-color: var(--light-orange);
    margin-left: 10px;
}
.desktop-menu a:nth-last-child(1):hover {
    background-color: var(--lightest-orange);
}
.mobile-menu {
    display: none;
}
@media only screen and (max-width: 468px){
    #__nuxt {
        overflow-x: hidden;
        position: relative;
    }
    .public-logo {
        width: 50%;
    }
    .desktop-menu {
        display: none;
    }
    .mobile-menu {
        display: block;
        position: absolute;
        right: 20px;
        top: 6vw;
    }
    .mobile-menu i {
        font-size: 30px;
    }
    .top-arrow {
        right: 25px;
        bottom: 40px;
    }
    .top-arrow button {
        height: 50px;
        width: 50px;
    }
}
</style>
