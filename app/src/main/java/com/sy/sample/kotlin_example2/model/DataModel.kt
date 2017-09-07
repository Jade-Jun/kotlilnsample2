package com.sy.sample.kotlin_example2.model

/**
 * Created by SuYa on 2017. 9. 6..
 */

class DataModel {

    data class ListItem(
            val idx : Int,
            val imgUrlString : String
    )

    companion object {
        fun getDefalutItems() : ArrayList<ListItem> {

            var items = ArrayList<ListItem>()
            val urlArray = getUrl()
            for (i in urlArray.indices) {
                val item = ListItem(i, urlArray[i])
                items.add(item)
            }

            return items
        }

        private fun getUrl() : Array<String> = arrayOf(
                "https://cdn.pixabay.com/photo/2015/06/22/08/37/children-817365__340.jpg",
                "https://cdn.pixabay.com/photo/2017/05/08/13/15/spring-bird-2295436__340.jpg",
                "https://cdn.pixabay.com/photo/2017/01/14/13/59/castelmezzano-1979546__340.jpg",
                "https://cdn.pixabay.com/photo/2016/11/30/15/23/apple-1873078__340.jpg",
                "https://cdn.pixabay.com/photo/2016/08/07/11/30/round-leaved-bellflower-1576086__340.jpg",
                "https://cdn.pixabay.com/photo/2017/03/14/14/49/cat-2143332__340.jpg",
                "https://cdn.pixabay.com/photo/2017/04/04/15/04/tulips-2201521__340.jpg",
                "https://cdn.pixabay.com/photo/2017/03/27/21/31/money-2180330__340.jpg",
                "https://cdn.pixabay.com/photo/2017/02/27/21/47/yogurt-2104327__340.jpg",
                "https://cdn.pixabay.com/photo/2017/01/05/11/16/icicle-1954827__340.jpg",
                "https://cdn.pixabay.com/photo/2017/03/11/08/22/surfing-2134595__340.jpg",
                "https://cdn.pixabay.com/photo/2017/09/01/16/35/fanes-2704749__340.jpg",
                "https://cdn.pixabay.com/photo/2017/09/01/14/59/fantasy-2704453__340.jpg",
                "https://cdn.pixabay.com/photo/2017/08/24/03/48/bay-2675337__340.jpg",
                "https://cdn.pixabay.com/photo/2017/08/06/22/41/grass-2597123__340.jpg"
        )
    }
}