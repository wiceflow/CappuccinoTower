package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class DiscusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public DiscusExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDiscusIdIsNull() {
            addCriterion("discus_id is null");
            return (Criteria) this;
        }

        public Criteria andDiscusIdIsNotNull() {
            addCriterion("discus_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiscusIdEqualTo(Integer value) {
            addCriterion("discus_id =", value, "discusId");
            return (Criteria) this;
        }

        public Criteria andDiscusIdNotEqualTo(Integer value) {
            addCriterion("discus_id <>", value, "discusId");
            return (Criteria) this;
        }

        public Criteria andDiscusIdGreaterThan(Integer value) {
            addCriterion("discus_id >", value, "discusId");
            return (Criteria) this;
        }

        public Criteria andDiscusIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("discus_id >=", value, "discusId");
            return (Criteria) this;
        }

        public Criteria andDiscusIdLessThan(Integer value) {
            addCriterion("discus_id <", value, "discusId");
            return (Criteria) this;
        }

        public Criteria andDiscusIdLessThanOrEqualTo(Integer value) {
            addCriterion("discus_id <=", value, "discusId");
            return (Criteria) this;
        }

        public Criteria andDiscusIdIn(List<Integer> values) {
            addCriterion("discus_id in", values, "discusId");
            return (Criteria) this;
        }

        public Criteria andDiscusIdNotIn(List<Integer> values) {
            addCriterion("discus_id not in", values, "discusId");
            return (Criteria) this;
        }

        public Criteria andDiscusIdBetween(Integer value1, Integer value2) {
            addCriterion("discus_id between", value1, value2, "discusId");
            return (Criteria) this;
        }

        public Criteria andDiscusIdNotBetween(Integer value1, Integer value2) {
            addCriterion("discus_id not between", value1, value2, "discusId");
            return (Criteria) this;
        }

        public Criteria andDTopicIsNull() {
            addCriterion("d_topic is null");
            return (Criteria) this;
        }

        public Criteria andDTopicIsNotNull() {
            addCriterion("d_topic is not null");
            return (Criteria) this;
        }

        public Criteria andDTopicEqualTo(String value) {
            addCriterion("d_topic =", value, "dTopic");
            return (Criteria) this;
        }

        public Criteria andDTopicNotEqualTo(String value) {
            addCriterion("d_topic <>", value, "dTopic");
            return (Criteria) this;
        }

        public Criteria andDTopicGreaterThan(String value) {
            addCriterion("d_topic >", value, "dTopic");
            return (Criteria) this;
        }

        public Criteria andDTopicGreaterThanOrEqualTo(String value) {
            addCriterion("d_topic >=", value, "dTopic");
            return (Criteria) this;
        }

        public Criteria andDTopicLessThan(String value) {
            addCriterion("d_topic <", value, "dTopic");
            return (Criteria) this;
        }

        public Criteria andDTopicLessThanOrEqualTo(String value) {
            addCriterion("d_topic <=", value, "dTopic");
            return (Criteria) this;
        }

        public Criteria andDTopicLike(String value) {
            addCriterion("d_topic like", value, "dTopic");
            return (Criteria) this;
        }

        public Criteria andDTopicNotLike(String value) {
            addCriterion("d_topic not like", value, "dTopic");
            return (Criteria) this;
        }

        public Criteria andDTopicIn(List<String> values) {
            addCriterion("d_topic in", values, "dTopic");
            return (Criteria) this;
        }

        public Criteria andDTopicNotIn(List<String> values) {
            addCriterion("d_topic not in", values, "dTopic");
            return (Criteria) this;
        }

        public Criteria andDTopicBetween(String value1, String value2) {
            addCriterion("d_topic between", value1, value2, "dTopic");
            return (Criteria) this;
        }

        public Criteria andDTopicNotBetween(String value1, String value2) {
            addCriterion("d_topic not between", value1, value2, "dTopic");
            return (Criteria) this;
        }

        public Criteria andCIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Integer value) {
            addCriterion("c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Integer value) {
            addCriterion("c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Integer value) {
            addCriterion("c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Integer value) {
            addCriterion("c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Integer> values) {
            addCriterion("c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Integer> values) {
            addCriterion("c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Integer value1, Integer value2) {
            addCriterion("c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_id not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andDiscusallIdIsNull() {
            addCriterion("discusall_id is null");
            return (Criteria) this;
        }

        public Criteria andDiscusallIdIsNotNull() {
            addCriterion("discusall_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiscusallIdEqualTo(Integer value) {
            addCriterion("discusall_id =", value, "discusallId");
            return (Criteria) this;
        }

        public Criteria andDiscusallIdNotEqualTo(Integer value) {
            addCriterion("discusall_id <>", value, "discusallId");
            return (Criteria) this;
        }

        public Criteria andDiscusallIdGreaterThan(Integer value) {
            addCriterion("discusall_id >", value, "discusallId");
            return (Criteria) this;
        }

        public Criteria andDiscusallIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("discusall_id >=", value, "discusallId");
            return (Criteria) this;
        }

        public Criteria andDiscusallIdLessThan(Integer value) {
            addCriterion("discusall_id <", value, "discusallId");
            return (Criteria) this;
        }

        public Criteria andDiscusallIdLessThanOrEqualTo(Integer value) {
            addCriterion("discusall_id <=", value, "discusallId");
            return (Criteria) this;
        }

        public Criteria andDiscusallIdIn(List<Integer> values) {
            addCriterion("discusall_id in", values, "discusallId");
            return (Criteria) this;
        }

        public Criteria andDiscusallIdNotIn(List<Integer> values) {
            addCriterion("discusall_id not in", values, "discusallId");
            return (Criteria) this;
        }

        public Criteria andDiscusallIdBetween(Integer value1, Integer value2) {
            addCriterion("discusall_id between", value1, value2, "discusallId");
            return (Criteria) this;
        }

        public Criteria andDiscusallIdNotBetween(Integer value1, Integer value2) {
            addCriterion("discusall_id not between", value1, value2, "discusallId");
            return (Criteria) this;
        }

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUNameIsNull() {
            addCriterion("u_name is null");
            return (Criteria) this;
        }

        public Criteria andUNameIsNotNull() {
            addCriterion("u_name is not null");
            return (Criteria) this;
        }

        public Criteria andUNameEqualTo(String value) {
            addCriterion("u_name =", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotEqualTo(String value) {
            addCriterion("u_name <>", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThan(String value) {
            addCriterion("u_name >", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThanOrEqualTo(String value) {
            addCriterion("u_name >=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThan(String value) {
            addCriterion("u_name <", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThanOrEqualTo(String value) {
            addCriterion("u_name <=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLike(String value) {
            addCriterion("u_name like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotLike(String value) {
            addCriterion("u_name not like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameIn(List<String> values) {
            addCriterion("u_name in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotIn(List<String> values) {
            addCriterion("u_name not in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameBetween(String value1, String value2) {
            addCriterion("u_name between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotBetween(String value1, String value2) {
            addCriterion("u_name not between", value1, value2, "uName");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}