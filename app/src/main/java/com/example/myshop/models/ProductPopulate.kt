package com.example.myshop.models

class ProductPopulate {
    companion object{
        public var list = ArrayList<Product>()
        public var added_food = ArrayList<Product>()
        public var added_ha = ArrayList<Product>()
        public var added_toys = ArrayList<Product>()

        public fun CreateFoodList(): ArrayList<Product>{
            list =  ArrayList<Product>()
            list.add(
                    Product(
                            "Potato",
                            "$5",
                            "https://cookilicious.com/wp-content/uploads/2016/01/BakedParmesanGarlicPotatoFingers-11.jpg"
                    )
            )
            list.add(
                    Product(
                            "Kebab",
                            "$30",
                            "https://turkishfoodie.com/wp-content/uploads/2019/12/Liver-Shish-Kebab-500x375.jpg"
                    )
            )
            list.add(
                    Product(
                            "Shawerma",
                            "$25",
                            "https://b.zmtcdn.com/data/pictures/0/5601100/66e79962fa7b23b37115509ee8b8411d_featured_v2.jpg"
                    )
            )
            list.add(
                    Product(
                            "Shweppes",
                            "$7",
                            "https://whiskylive.co.za/wp-content/uploads/2019/10/WL_28102019b.jpg"
                    )
            )
            list.addAll(added_food)
            return list
        }

        public fun CreateHaList(): ArrayList<Product>{
            list =  ArrayList<Product>()
            list.add(
                    Product(
                            "Iron",
                            "$357",
                            "https://www.house.com.au/images/CategoryImages/iron.jpg"
                    )
            )
            list.add(
                    Product(
                            "Fan",
                            "$88",
                            "https://www.house.com.au/images/CategoryImages/fan.jpg"
                    )
            )
            list.add(
                    Product(
                            "Grooming Pack",
                            "$540",
                            "https://www.house.com.au/images/CategoryImages/grooming.jpg"
                    )
            )
            list.add(
                    Product(
                            "Vacuum Cleaner",
                            "$999",
                            "https://www.house.com.au/images/CategoryImages/cleaning.jpg"
                    )
            )
            list.addAll(added_ha)
            return list
        }

        public fun CreateToysList(): ArrayList<Product>{
            list =  ArrayList<Product>()
            list.add(
                    Product(
                            "Plane",
                            "$90",
                            "https://www.sgs-latam.com/-/media/global/images/structural-website-images/hero-images/hero-toys-on-blue-background.jpg"
                    )
            )
            list.add(
                    Product(
                            "Pickup Truck",
                            "$112",
                            "https://www.productliabilityandmasstorts.com/wp-content/uploads/sites/762/2017/11/GettyImages-667108156-1-550x303.jpg"
                    )
            )
            list.add(
                    Product(
                            "Baby Gear",
                            "$1100",
                            "https://s7d1.scene7.com/is/image/mattelsites/FP_CDA_LP_GVH47_Mobile"
                    )
            )
            list.addAll(added_toys)
            return list
        }
    }
}
