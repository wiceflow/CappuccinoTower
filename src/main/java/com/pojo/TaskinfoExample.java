package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class TaskinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public TaskinfoExample() {
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

        public Criteria andTaskinfoIdIsNull() {
            addCriterion("taskinfo_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskinfoIdIsNotNull() {
            addCriterion("taskinfo_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskinfoIdEqualTo(Integer value) {
            addCriterion("taskinfo_id =", value, "taskinfoId");
            return (Criteria) this;
        }

        public Criteria andTaskinfoIdNotEqualTo(Integer value) {
            addCriterion("taskinfo_id <>", value, "taskinfoId");
            return (Criteria) this;
        }

        public Criteria andTaskinfoIdGreaterThan(Integer value) {
            addCriterion("taskinfo_id >", value, "taskinfoId");
            return (Criteria) this;
        }

        public Criteria andTaskinfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("taskinfo_id >=", value, "taskinfoId");
            return (Criteria) this;
        }

        public Criteria andTaskinfoIdLessThan(Integer value) {
            addCriterion("taskinfo_id <", value, "taskinfoId");
            return (Criteria) this;
        }

        public Criteria andTaskinfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("taskinfo_id <=", value, "taskinfoId");
            return (Criteria) this;
        }

        public Criteria andTaskinfoIdIn(List<Integer> values) {
            addCriterion("taskinfo_id in", values, "taskinfoId");
            return (Criteria) this;
        }

        public Criteria andTaskinfoIdNotIn(List<Integer> values) {
            addCriterion("taskinfo_id not in", values, "taskinfoId");
            return (Criteria) this;
        }

        public Criteria andTaskinfoIdBetween(Integer value1, Integer value2) {
            addCriterion("taskinfo_id between", value1, value2, "taskinfoId");
            return (Criteria) this;
        }

        public Criteria andTaskinfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("taskinfo_id not between", value1, value2, "taskinfoId");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNameIsNull() {
            addCriterion("taskinfo_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNameIsNotNull() {
            addCriterion("taskinfo_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNameEqualTo(String value) {
            addCriterion("taskinfo_name =", value, "taskinfoName");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNameNotEqualTo(String value) {
            addCriterion("taskinfo_name <>", value, "taskinfoName");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNameGreaterThan(String value) {
            addCriterion("taskinfo_name >", value, "taskinfoName");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNameGreaterThanOrEqualTo(String value) {
            addCriterion("taskinfo_name >=", value, "taskinfoName");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNameLessThan(String value) {
            addCriterion("taskinfo_name <", value, "taskinfoName");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNameLessThanOrEqualTo(String value) {
            addCriterion("taskinfo_name <=", value, "taskinfoName");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNameLike(String value) {
            addCriterion("taskinfo_name like", value, "taskinfoName");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNameNotLike(String value) {
            addCriterion("taskinfo_name not like", value, "taskinfoName");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNameIn(List<String> values) {
            addCriterion("taskinfo_name in", values, "taskinfoName");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNameNotIn(List<String> values) {
            addCriterion("taskinfo_name not in", values, "taskinfoName");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNameBetween(String value1, String value2) {
            addCriterion("taskinfo_name between", value1, value2, "taskinfoName");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNameNotBetween(String value1, String value2) {
            addCriterion("taskinfo_name not between", value1, value2, "taskinfoName");
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

        public Criteria andTaskinfoUserIsNull() {
            addCriterion("taskinfo_user is null");
            return (Criteria) this;
        }

        public Criteria andTaskinfoUserIsNotNull() {
            addCriterion("taskinfo_user is not null");
            return (Criteria) this;
        }

        public Criteria andTaskinfoUserEqualTo(Integer value) {
            addCriterion("taskinfo_user =", value, "taskinfoUser");
            return (Criteria) this;
        }

        public Criteria andTaskinfoUserNotEqualTo(Integer value) {
            addCriterion("taskinfo_user <>", value, "taskinfoUser");
            return (Criteria) this;
        }

        public Criteria andTaskinfoUserGreaterThan(Integer value) {
            addCriterion("taskinfo_user >", value, "taskinfoUser");
            return (Criteria) this;
        }

        public Criteria andTaskinfoUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("taskinfo_user >=", value, "taskinfoUser");
            return (Criteria) this;
        }

        public Criteria andTaskinfoUserLessThan(Integer value) {
            addCriterion("taskinfo_user <", value, "taskinfoUser");
            return (Criteria) this;
        }

        public Criteria andTaskinfoUserLessThanOrEqualTo(Integer value) {
            addCriterion("taskinfo_user <=", value, "taskinfoUser");
            return (Criteria) this;
        }

        public Criteria andTaskinfoUserIn(List<Integer> values) {
            addCriterion("taskinfo_user in", values, "taskinfoUser");
            return (Criteria) this;
        }

        public Criteria andTaskinfoUserNotIn(List<Integer> values) {
            addCriterion("taskinfo_user not in", values, "taskinfoUser");
            return (Criteria) this;
        }

        public Criteria andTaskinfoUserBetween(Integer value1, Integer value2) {
            addCriterion("taskinfo_user between", value1, value2, "taskinfoUser");
            return (Criteria) this;
        }

        public Criteria andTaskinfoUserNotBetween(Integer value1, Integer value2) {
            addCriterion("taskinfo_user not between", value1, value2, "taskinfoUser");
            return (Criteria) this;
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