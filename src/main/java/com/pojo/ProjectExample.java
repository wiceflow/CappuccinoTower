package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ProjectExample() {
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

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPNameIsNull() {
            addCriterion("p_name is null");
            return (Criteria) this;
        }

        public Criteria andPNameIsNotNull() {
            addCriterion("p_name is not null");
            return (Criteria) this;
        }

        public Criteria andPNameEqualTo(String value) {
            addCriterion("p_name =", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotEqualTo(String value) {
            addCriterion("p_name <>", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThan(String value) {
            addCriterion("p_name >", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThanOrEqualTo(String value) {
            addCriterion("p_name >=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThan(String value) {
            addCriterion("p_name <", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThanOrEqualTo(String value) {
            addCriterion("p_name <=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLike(String value) {
            addCriterion("p_name like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotLike(String value) {
            addCriterion("p_name not like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameIn(List<String> values) {
            addCriterion("p_name in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotIn(List<String> values) {
            addCriterion("p_name not in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameBetween(String value1, String value2) {
            addCriterion("p_name between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotBetween(String value1, String value2) {
            addCriterion("p_name not between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPSensitiveIsNull() {
            addCriterion("p_sensitive is null");
            return (Criteria) this;
        }

        public Criteria andPSensitiveIsNotNull() {
            addCriterion("p_sensitive is not null");
            return (Criteria) this;
        }

        public Criteria andPSensitiveEqualTo(Integer value) {
            addCriterion("p_sensitive =", value, "pSensitive");
            return (Criteria) this;
        }

        public Criteria andPSensitiveNotEqualTo(Integer value) {
            addCriterion("p_sensitive <>", value, "pSensitive");
            return (Criteria) this;
        }

        public Criteria andPSensitiveGreaterThan(Integer value) {
            addCriterion("p_sensitive >", value, "pSensitive");
            return (Criteria) this;
        }

        public Criteria andPSensitiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_sensitive >=", value, "pSensitive");
            return (Criteria) this;
        }

        public Criteria andPSensitiveLessThan(Integer value) {
            addCriterion("p_sensitive <", value, "pSensitive");
            return (Criteria) this;
        }

        public Criteria andPSensitiveLessThanOrEqualTo(Integer value) {
            addCriterion("p_sensitive <=", value, "pSensitive");
            return (Criteria) this;
        }

        public Criteria andPSensitiveIn(List<Integer> values) {
            addCriterion("p_sensitive in", values, "pSensitive");
            return (Criteria) this;
        }

        public Criteria andPSensitiveNotIn(List<Integer> values) {
            addCriterion("p_sensitive not in", values, "pSensitive");
            return (Criteria) this;
        }

        public Criteria andPSensitiveBetween(Integer value1, Integer value2) {
            addCriterion("p_sensitive between", value1, value2, "pSensitive");
            return (Criteria) this;
        }

        public Criteria andPSensitiveNotBetween(Integer value1, Integer value2) {
            addCriterion("p_sensitive not between", value1, value2, "pSensitive");
            return (Criteria) this;
        }

        public Criteria andIspublicIsNull() {
            addCriterion("ispublic is null");
            return (Criteria) this;
        }

        public Criteria andIspublicIsNotNull() {
            addCriterion("ispublic is not null");
            return (Criteria) this;
        }

        public Criteria andIspublicEqualTo(Integer value) {
            addCriterion("ispublic =", value, "ispublic");
            return (Criteria) this;
        }

        public Criteria andIspublicNotEqualTo(Integer value) {
            addCriterion("ispublic <>", value, "ispublic");
            return (Criteria) this;
        }

        public Criteria andIspublicGreaterThan(Integer value) {
            addCriterion("ispublic >", value, "ispublic");
            return (Criteria) this;
        }

        public Criteria andIspublicGreaterThanOrEqualTo(Integer value) {
            addCriterion("ispublic >=", value, "ispublic");
            return (Criteria) this;
        }

        public Criteria andIspublicLessThan(Integer value) {
            addCriterion("ispublic <", value, "ispublic");
            return (Criteria) this;
        }

        public Criteria andIspublicLessThanOrEqualTo(Integer value) {
            addCriterion("ispublic <=", value, "ispublic");
            return (Criteria) this;
        }

        public Criteria andIspublicIn(List<Integer> values) {
            addCriterion("ispublic in", values, "ispublic");
            return (Criteria) this;
        }

        public Criteria andIspublicNotIn(List<Integer> values) {
            addCriterion("ispublic not in", values, "ispublic");
            return (Criteria) this;
        }

        public Criteria andIspublicBetween(Integer value1, Integer value2) {
            addCriterion("ispublic between", value1, value2, "ispublic");
            return (Criteria) this;
        }

        public Criteria andIspublicNotBetween(Integer value1, Integer value2) {
            addCriterion("ispublic not between", value1, value2, "ispublic");
            return (Criteria) this;
        }

        public Criteria andTIdIsNull() {
            addCriterion("t_id is null");
            return (Criteria) this;
        }

        public Criteria andTIdIsNotNull() {
            addCriterion("t_id is not null");
            return (Criteria) this;
        }

        public Criteria andTIdEqualTo(Integer value) {
            addCriterion("t_id =", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotEqualTo(Integer value) {
            addCriterion("t_id <>", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThan(Integer value) {
            addCriterion("t_id >", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_id >=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThan(Integer value) {
            addCriterion("t_id <", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThanOrEqualTo(Integer value) {
            addCriterion("t_id <=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdIn(List<Integer> values) {
            addCriterion("t_id in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotIn(List<Integer> values) {
            addCriterion("t_id not in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdBetween(Integer value1, Integer value2) {
            addCriterion("t_id between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotBetween(Integer value1, Integer value2) {
            addCriterion("t_id not between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andDiscusallidIsNull() {
            addCriterion("discusallid is null");
            return (Criteria) this;
        }

        public Criteria andDiscusallidIsNotNull() {
            addCriterion("discusallid is not null");
            return (Criteria) this;
        }

        public Criteria andDiscusallidEqualTo(Integer value) {
            addCriterion("discusallid =", value, "discusallid");
            return (Criteria) this;
        }

        public Criteria andDiscusallidNotEqualTo(Integer value) {
            addCriterion("discusallid <>", value, "discusallid");
            return (Criteria) this;
        }

        public Criteria andDiscusallidGreaterThan(Integer value) {
            addCriterion("discusallid >", value, "discusallid");
            return (Criteria) this;
        }

        public Criteria andDiscusallidGreaterThanOrEqualTo(Integer value) {
            addCriterion("discusallid >=", value, "discusallid");
            return (Criteria) this;
        }

        public Criteria andDiscusallidLessThan(Integer value) {
            addCriterion("discusallid <", value, "discusallid");
            return (Criteria) this;
        }

        public Criteria andDiscusallidLessThanOrEqualTo(Integer value) {
            addCriterion("discusallid <=", value, "discusallid");
            return (Criteria) this;
        }

        public Criteria andDiscusallidIn(List<Integer> values) {
            addCriterion("discusallid in", values, "discusallid");
            return (Criteria) this;
        }

        public Criteria andDiscusallidNotIn(List<Integer> values) {
            addCriterion("discusallid not in", values, "discusallid");
            return (Criteria) this;
        }

        public Criteria andDiscusallidBetween(Integer value1, Integer value2) {
            addCriterion("discusallid between", value1, value2, "discusallid");
            return (Criteria) this;
        }

        public Criteria andDiscusallidNotBetween(Integer value1, Integer value2) {
            addCriterion("discusallid not between", value1, value2, "discusallid");
            return (Criteria) this;
        }

        public Criteria andFTotalidIsNull() {
            addCriterion("f_totalid is null");
            return (Criteria) this;
        }

        public Criteria andFTotalidIsNotNull() {
            addCriterion("f_totalid is not null");
            return (Criteria) this;
        }

        public Criteria andFTotalidEqualTo(Integer value) {
            addCriterion("f_totalid =", value, "fTotalid");
            return (Criteria) this;
        }

        public Criteria andFTotalidNotEqualTo(Integer value) {
            addCriterion("f_totalid <>", value, "fTotalid");
            return (Criteria) this;
        }

        public Criteria andFTotalidGreaterThan(Integer value) {
            addCriterion("f_totalid >", value, "fTotalid");
            return (Criteria) this;
        }

        public Criteria andFTotalidGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_totalid >=", value, "fTotalid");
            return (Criteria) this;
        }

        public Criteria andFTotalidLessThan(Integer value) {
            addCriterion("f_totalid <", value, "fTotalid");
            return (Criteria) this;
        }

        public Criteria andFTotalidLessThanOrEqualTo(Integer value) {
            addCriterion("f_totalid <=", value, "fTotalid");
            return (Criteria) this;
        }

        public Criteria andFTotalidIn(List<Integer> values) {
            addCriterion("f_totalid in", values, "fTotalid");
            return (Criteria) this;
        }

        public Criteria andFTotalidNotIn(List<Integer> values) {
            addCriterion("f_totalid not in", values, "fTotalid");
            return (Criteria) this;
        }

        public Criteria andFTotalidBetween(Integer value1, Integer value2) {
            addCriterion("f_totalid between", value1, value2, "fTotalid");
            return (Criteria) this;
        }

        public Criteria andFTotalidNotBetween(Integer value1, Integer value2) {
            addCriterion("f_totalid not between", value1, value2, "fTotalid");
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