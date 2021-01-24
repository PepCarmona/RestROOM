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
