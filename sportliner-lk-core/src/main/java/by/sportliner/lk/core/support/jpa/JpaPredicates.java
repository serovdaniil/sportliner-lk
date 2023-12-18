package by.sportliner.lk.core.support.jpa;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.repository.query.EscapeCharacter;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Helper class for creating complex JPA {@link Predicate}s.
 */
public class JpaPredicates {

    public static Predicate ilike(CriteriaBuilder cb,
                                  Expression<String> x,
                                  Expression<String> pattern,
                                  Expression<Character> escapeChar) {
        return cb.like(cb.lower(x), cb.lower(pattern), escapeChar);
    }

    public static Predicate contains(CriteriaBuilder cb, Expression<String> x, String value) {
        EscapeCharacter escapeCharacter = EscapeCharacter.DEFAULT;

        return ilike(
            cb, x, cb.literal(createContainsLikePattern(escapeCharacter, value)), cb.literal(escapeCharacter.getEscapeCharacter())
        );
    }

    public static <Y extends Comparable<? super Y>> Predicate compare(CriteriaBuilder cb,
                                                                      ComparisonOperator operator,
                                                                      Expression<? extends Y> x,
                                                                      Y y) {
        return compare(cb, operator, x, cb.literal(y));
    }

    public static <Y extends Comparable<? super Y>> Predicate compare(CriteriaBuilder cb,
                                                                      ComparisonOperator operator,
                                                                      Expression<? extends Y> x,
                                                                      Expression<? extends Y> y) {

        return switch (operator) {
            case LESS -> cb.lessThan(x, y);
            case LESS_OR_EQUAL -> cb.lessThanOrEqualTo(x, y);
            case EQUAL -> cb.equal(x, y);
            case GREATER_OR_EQUAL -> cb.greaterThanOrEqualTo(x, y);
            case GREATER -> cb.greaterThan(x, y);
        };

    }

    @SafeVarargs
    public static Predicate containsAllWords(CriteriaBuilder cb, String text, Expression<String>... fields) {
        if (text == null || text.isEmpty()) {
            return cb.conjunction();
        }

        Predicate result = cb.conjunction();

        Set<String> words = Arrays
            .stream(text.split("\\s+"))
            .collect(Collectors.toSet());

        for (String token : words) {
            Predicate[] fieldsPredicates = Arrays.stream(fields)
                .map(field -> contains(cb, field, token))
                .toArray(Predicate[]::new);

            result = cb.and(result, cb.or(fieldsPredicates));
        }

        return result;
    }

    private static String createContainsLikePattern(EscapeCharacter escapeCharacter, String value) {
        return '%' + escapeCharacter.escape(value) + '%';
    }

}
