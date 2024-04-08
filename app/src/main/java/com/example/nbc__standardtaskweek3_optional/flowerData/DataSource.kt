package com.example.nbc__standardtaskweek3_optional.flowerData

class DataSource {
    companion object {
        private var INSTACE : DataSource? = null
        fun getDataSource() : DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTACE ?: DataSource()
                INSTACE = newInstance
                newInstance
            }
        }
    }

    fun getFlowerList() : List<Flower> {
        return flowerList()
    }
}