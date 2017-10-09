package com.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CommentExample() {
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

        public Criteria andCContentIsNull() {
            addCriterion("c_content is null");
            return (Criteria) this;
        }

        public Criteria andCContentIsNotNull() {
            addCriterion("c_content is not null");
            return (Criteria) this;
        }

        public Criteria andCContentEqualTo(String value) {
            addCriterion("c_content =", value, "cContent");
            return (Criteria) this;
        }

        public Criteria andCContentNotEqualTo(String value) {
            addCriterion("c_content <>", value, "cContent");
            return (Criteria) this;
        }

        public Criteria andCContentGreaterThan(String value) {
            addCriterion("c_content >", value, "cContent");
            return (Criteria) this;
        }

        public Criteria andCContentGreaterThanOrEqualTo(String value) {
            addCriterion("c_content >=", value, "cContent");
            return (Criteria) this;
        }

        public Criteria andCContentLessThan(String value) {
            addCriterion("c_content <", value, "cContent");
            return (Criteria) this;
        }

        public Criteria andCContentLessThanOrEqualTo(String value) {
            addCriterion("c_content <=", value, "cContent");
            return (Criteria) this;
        }

        public Criteria andCContentLike(String value) {
            addCriterion("c_content like", value, "cContent");
            return (Criteria) this;
        }

        public Criteria andCContentNotLike(String value) {
            addCriterion("c_content not like", value, "cContent");
            return (Criteria) this;
        }

        public Criteria andCContentIn(List<String> values) {
            addCriterion("c_content in", values, "cContent");
            return (Criteria) this;
        }

        public Criteria andCContentNotIn(List<String> values) {
            addCriterion("c_content not in", values, "cContent");
            return (Criteria) this;
        }

        public Criteria andCContentBetween(String value1, String value2) {
            addCriterion("c_content between", value1, value2, "cContent");
            return (Criteria) this;
        }

        public Criteria andCContentNotBetween(String value1, String value2) {
            addCriterion("c_content not between", value1, value2, "cContent");
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andCTimeIsNull() {
            addCriterion("c_time is null");
            return (Criteria) this;
        }

        public Criteria andCTimeIsNotNull() {
            addCriterion("c_time is not null");
            return (Criteria) this;
        }

        public Criteria andCTimeEqualTo(Date value) {
            addCriterion("c_time =", value, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeNotEqualTo(Date value) {
            addCriterion("c_time <>", value, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeGreaterThan(Date value) {
            addCriterion("c_time >", value, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("c_time >=", value, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeLessThan(Date value) {
            addCriterion("c_time <", value, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeLessThanOrEqualTo(Date value) {
            addCriterion("c_time <=", value, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeIn(List<Date> values) {
            addCriterion("c_time in", values, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeNotIn(List<Date> values) {
            addCriterion("c_time not in", values, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeBetween(Date value1, Date value2) {
            addCriterion("c_time between", value1, value2, "cTime");
            return (Criteria) this;
        }

        public Criteria andCTimeNotBetween(Date value1, Date value2) {
            addCriterion("c_time not between", value1, value2, "cTime");
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

        public Criteria andBuIdIsNull() {
            addCriterion("bu_id is null");
            return (Criteria) this;
        }

        public Criteria andBuIdIsNotNull() {
            addCriterion("bu_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuIdEqualTo(Integer value) {
            addCriterion("bu_id =", value, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdNotEqualTo(Integer value) {
            addCriterion("bu_id <>", value, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdGreaterThan(Integer value) {
            addCriterion("bu_id >", value, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bu_id >=", value, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdLessThan(Integer value) {
            addCriterion("bu_id <", value, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdLessThanOrEqualTo(Integer value) {
            addCriterion("bu_id <=", value, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdIn(List<Integer> values) {
            addCriterion("bu_id in", values, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdNotIn(List<Integer> values) {
            addCriterion("bu_id not in", values, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdBetween(Integer value1, Integer value2) {
            addCriterion("bu_id between", value1, value2, "buId");
            return (Criteria) this;
        }

        public Criteria andBuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bu_id not between", value1, value2, "buId");
            return (Criteria) this;
        }

        public Criteria andBuUsernameIsNull() {
            addCriterion("bu_username is null");
            return (Criteria) this;
        }

        public Criteria andBuUsernameIsNotNull() {
            addCriterion("bu_username is not null");
            return (Criteria) this;
        }

        public Criteria andBuUsernameEqualTo(String value) {
            addCriterion("bu_username =", value, "buUsername");
            return (Criteria) this;
        }

        public Criteria andBuUsernameNotEqualTo(String value) {
            addCriterion("bu_username <>", value, "buUsername");
            return (Criteria) this;
        }

        public Criteria andBuUsernameGreaterThan(String value) {
            addCriterion("bu_username >", value, "buUsername");
            return (Criteria) this;
        }

        public Criteria andBuUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("bu_username >=", value, "buUsername");
            return (Criteria) this;
        }

        public Criteria andBuUsernameLessThan(String value) {
            addCriterion("bu_username <", value, "buUsername");
            return (Criteria) this;
        }

        public Criteria andBuUsernameLessThanOrEqualTo(String value) {
            addCriterion("bu_username <=", value, "buUsername");
            return (Criteria) this;
        }

        public Criteria andBuUsernameLike(String value) {
            addCriterion("bu_username like", value, "buUsername");
            return (Criteria) this;
        }

        public Criteria andBuUsernameNotLike(String value) {
            addCriterion("bu_username not like", value, "buUsername");
            return (Criteria) this;
        }

        public Criteria andBuUsernameIn(List<String> values) {
            addCriterion("bu_username in", values, "buUsername");
            return (Criteria) this;
        }

        public Criteria andBuUsernameNotIn(List<String> values) {
            addCriterion("bu_username not in", values, "buUsername");
            return (Criteria) this;
        }

        public Criteria andBuUsernameBetween(String value1, String value2) {
            addCriterion("bu_username between", value1, value2, "buUsername");
            return (Criteria) this;
        }

        public Criteria andBuUsernameNotBetween(String value1, String value2) {
            addCriterion("bu_username not between", value1, value2, "buUsername");
            return (Criteria) this;
        }

        public Criteria andBcIdIsNull() {
            addCriterion("bc_id is null");
            return (Criteria) this;
        }

        public Criteria andBcIdIsNotNull() {
            addCriterion("bc_id is not null");
            return (Criteria) this;
        }

        public Criteria andBcIdEqualTo(Integer value) {
            addCriterion("bc_id =", value, "bcId");
            return (Criteria) this;
        }

        public Criteria andBcIdNotEqualTo(Integer value) {
            addCriterion("bc_id <>", value, "bcId");
            return (Criteria) this;
        }

        public Criteria andBcIdGreaterThan(Integer value) {
            addCriterion("bc_id >", value, "bcId");
            return (Criteria) this;
        }

        public Criteria andBcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bc_id >=", value, "bcId");
            return (Criteria) this;
        }

        public Criteria andBcIdLessThan(Integer value) {
            addCriterion("bc_id <", value, "bcId");
            return (Criteria) this;
        }

        public Criteria andBcIdLessThanOrEqualTo(Integer value) {
            addCriterion("bc_id <=", value, "bcId");
            return (Criteria) this;
        }

        public Criteria andBcIdIn(List<Integer> values) {
            addCriterion("bc_id in", values, "bcId");
            return (Criteria) this;
        }

        public Criteria andBcIdNotIn(List<Integer> values) {
            addCriterion("bc_id not in", values, "bcId");
            return (Criteria) this;
        }

        public Criteria andBcIdBetween(Integer value1, Integer value2) {
            addCriterion("bc_id between", value1, value2, "bcId");
            return (Criteria) this;
        }

        public Criteria andBcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bc_id not between", value1, value2, "bcId");
            return (Criteria) this;
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