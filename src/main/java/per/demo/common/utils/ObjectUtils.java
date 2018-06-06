package per.demo.common.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;

/**
 * ObjectUtils
 *
 * @author Wilson
 * @date 18-5-8
 */
public class ObjectUtils {
    public static <T> T copyProperties(T target, Object source) {
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <T> T copyProperties(T target, Object... sources) {
        for (Object source : sources) {
            BeanUtils.copyProperties(target, source);
        }
        return target;
    }

    public static <T> T copyProperties(Object source, T target, String... ignoreProperties) throws BeansException {
        BeanUtils.copyProperties(source, target, ignoreProperties);
        return target;
    }
}
