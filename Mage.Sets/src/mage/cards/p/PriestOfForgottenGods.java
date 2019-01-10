package mage.cards.p;

import mage.MageInt;
import mage.Mana;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.abilities.effects.common.LoseLifeTargetEffect;
import mage.abilities.effects.common.SacrificeEffect;
import mage.abilities.effects.mana.BasicManaEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.filter.StaticFilters;

import java.util.UUID;

/**
 * @author TheElk801
 */
public final class PriestOfForgottenGods extends CardImpl {

    public PriestOfForgottenGods(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.CREATURE}, "{1}{B}");

        this.subtype.add(SubType.HUMAN);
        this.subtype.add(SubType.CLERIC);
        this.power = new MageInt(1);
        this.toughness = new MageInt(2);

        // {T}, Sacrifice two other creatures: Any number of target players each lose 2 life and sacrifice a creature. You add {B}{B} and draw a card.
        Ability ability = new SimpleActivatedAbility(
                new LoseLifeTargetEffect(2)
                        .setText("Any number of target players each lose 2 life"),
                new TapSourceCost()
        );
        ability.addEffect(
                new SacrificeEffect(StaticFilters.FILTER_PERMANENT_CREATURE, 1, "")
                        .setText("and sacrifice a creature")
        );
        ability.addEffect(new BasicManaEffect(Mana.BlackMana(2)).setText("You add {B}{B}"));
        ability.addEffect(new DrawCardSourceControllerEffect(1).setText("and draw a card"));
        this.addAbility(ability);
    }

    private PriestOfForgottenGods(final PriestOfForgottenGods card) {
        super(card);
    }

    @Override
    public PriestOfForgottenGods copy() {
        return new PriestOfForgottenGods(this);
    }
}