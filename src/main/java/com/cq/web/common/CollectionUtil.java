package com.cq.web.common;

/**
 * 集合相关工具类，包括数组
 * @Author Celine Q
 * @Create 8/10/2018 2:46 PM
 **/
public class CollectionUtil {

    private CollectionUtil() {
        // 静态类不可实例化
    }

    /**
     * 以 Conjunction 为分隔符将集合转换为字符串
     * @param collection 集合
     * @param conjunction 分隔符
     * @param <T> 被处理的集合
     * @return 连接后的字符串
     */
    public static <T> String join(Iterable<T> collection, String conjunction) {
       StringBuilder sb = new StringBuilder();
       boolean isFirst = true;
       for (T item : collection){
           if(isFirst)
               isFirst = false;
           else
               sb.append(conjunction);
           sb.append(item);
       }
       return sb.toString();
    }


    /**
     *  以 Conjunction 为分隔符将数组转换为字符串
     * @param array 数组
     * @param conjunction 分隔符
     * @param <T> 被处理的数组
     * @return 连接后的字符串
     */
    public static <T> String join(T[] array, String conjunction) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (T item : array){
            if(isFirst)
                isFirst = false;
            else
                sb.append(conjunction);
            sb.append(item);
        }
        return sb.toString();
    }


}
