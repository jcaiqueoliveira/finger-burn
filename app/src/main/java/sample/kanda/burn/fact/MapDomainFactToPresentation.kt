package sample.kanda.burn.fact

import kanda.libs.domain.ChuckNorrisFact

/**
 * Created by caique on 3/12/18.
 */
object MapDomainFactToPresentation {
    operator fun invoke(fact: ChuckNorrisFact): FactView {
        return fact.run {
            FactView(
                    itemType = getSizeText(phrase),
                    color = getColorButton(category),
                    icoUrl = iconUrl,
                    url = url,
                    phrase = phrase
            )
        }
    }

    private fun getSizeText(phrase: String): ItemViewType {
        return if (phrase.length >= 50) {
            MinTextSize
        } else {
            MaxTextSize
        }
    }

    private fun getColorButton(category: String?): Int {
        return if (category.isNullOrEmpty()) {
            Constants.COLOR_TEXT_EMPTY_CATEGORY
        } else {
            Constants.COLOR_TEXT_WITH_CATEGORY
        }
    }
}

