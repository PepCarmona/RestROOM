import FoodService from '~/assets/service/FoodService'

export default (ctx, inject) => {
  const services = {
    food: new FoodService(ctx.$axios)
  }

  inject('services', services)
}
