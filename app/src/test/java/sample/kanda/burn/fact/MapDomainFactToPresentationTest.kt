package sample.kanda.burn.fact

import kanda.libs.domain.ChuckNorrisFact
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * Created by caique on 3/12/18.
 */
class MapDomainFactToPresentationTest {

    @Test
    fun `given a text and a category should map to a correct color and text size`() {
        val fact = ChuckNorrisFact(
                iconUrl = "",
                category = null,
                url = "",
                phrase = "any sentence here")

        val factView = MapDomainFactToPresentation(fact)

        assertThat(factView.itemType)
                .isInstanceOf(MaxTextSize::class.java)

        assertThat(factView.color)
                .isEqualTo(Constants.COLOR_TEXT_EMPTY_CATEGORY)
    }


}