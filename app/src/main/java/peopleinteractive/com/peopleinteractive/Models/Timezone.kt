package peopleinteractive.com.peopleinteractive.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Timezone {

    @SerializedName("offset")
    @Expose
    var offset: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null

}
