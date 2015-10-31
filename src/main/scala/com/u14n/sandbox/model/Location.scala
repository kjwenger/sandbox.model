package com.u14n.sandbox.model

import scala.beans.BeanProperty

/**
 * @author ${user.name}
 */
class Location (@BeanProperty var zipCode: String) {
    def this() {
        this("")
    }
}
