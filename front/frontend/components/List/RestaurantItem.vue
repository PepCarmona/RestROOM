<template>
  <nuxt-link :to="{ name: 'menu'}">
    <div :id="'restaurant-'+ restaurant.id" class="restaurant-item container ccard" @click="setRestaurant">
      <div class="row">
        <div class="restaurant-thumbnail col-3">
          <p>opened</p>
        </div>
        <div class="restaurant-info col-8">
          <h3>{{ restaurant.name }}</h3>
          <p>{{ restaurant.description }}</p>
          <p>business hours</p>
        </div>
      </div>
    </div>
  </nuxt-link>
</template>
<script>
export default {
  props: {
    restaurant: {
      type: Object,
      default () {
        return {}
      }
    }
  },
  methods: {
    setRestaurant () {
      this.$store.commit('setRestaurant', this.restaurant)
    }
  }
}
</script>
<style scoped>
.restaurant-item {
    background-color: rgba(255,255,255,0.322);
    padding: 10px 0px 10px 20px;
    margin-bottom: 20px;
    cursor: pointer;
    box-sizing: border-box;
}
.restaurant-thumbnail {
    display: flex;
    align-items: flex-end;
    justify-content: center;
    height: 150px;
    width: 150px;
    background-color: paleturquoise;
}
.restaurant-thumbnail p {
    width: fit-content;
    padding: 0px 8px 3px 8px;
    border-radius: 15px;
    background-color: rgba(255, 255, 255, 0.322);
}
.restaurant-info p:nth-child(3) {
    margin-top: 8%;
    margin-left: 100%;
    width: max-content;
    padding: 0px 5px 0px 5px;
    border-radius: 5px;
    background-color: rgba(255, 255, 255, 0.322);
}
</style>
