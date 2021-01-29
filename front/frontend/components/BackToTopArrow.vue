<template>
  <div class="btn top-arrow">
    <button class="btn">
      <i class="fas fa-arrow-up" />
    </button>
  </div>
</template>
<style scoped>
.top-arrow {
    display: none;
    position: fixed;
    bottom: 15px;
    right: 15px;
    z-index: 99;
}
.top-arrow button {
    height: 55px;
    width: 55px;
    background-color: rgba(255, 166, 0, 0.637);
    border: 1px solid var(--border-gray);
    border-radius: 5px;
}
.top-arrow button i {
    font-size: 25px;
    color: var(--letter-gray);
}
</style>
