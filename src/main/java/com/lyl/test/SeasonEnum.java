package com.lyl.test;

/**

 * <p> Description : SeasonEnum.java
 *
 * @author : liuyuanlong
 * @date : 2020/4/27 9:34
 */
public enum  SeasonEnum {

        SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);
        private int seq;
        SeasonEnum(int seq) {
            this.seq = seq;
        }
        public int getSeq() {
            return seq;
        }

}
