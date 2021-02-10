export const state = () => ({
  selectedRestaurant: {}
})

export const mutations = {
  setRestaurant (state, restaurant) {
    state.selectedRestaurant = restaurant
  }
}
