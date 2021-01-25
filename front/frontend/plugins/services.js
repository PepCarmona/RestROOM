import FoodService from '~/assets/service/FoodService'
import MenuService from '~/assets/service/MenuService'
import PublicService from '~/assets/service/PublicService'

export default (ctx, inject) => {
  const services = {
    food: new FoodService(ctx.$axios),
    menu: new MenuService(ctx.$axios),
    public: new PublicService(ctx.$axios)
  }

  inject('services', services)
}
