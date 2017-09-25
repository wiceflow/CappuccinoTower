package com.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public TaskExample() {
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

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskCreatetimeIsNull() {
            addCriterion("task_createtime is null");
            return (Criteria) this;
        }

        public Criteria andTaskCreatetimeIsNotNull() {
            addCriterion("task_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCreatetimeEqualTo(Date value) {
            addCriterion("task_createtime =", value, "taskCreatetime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatetimeNotEqualTo(Date value) {
            addCriterion("task_createtime <>", value, "taskCreatetime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatetimeGreaterThan(Date value) {
            addCriterion("task_createtime >", value, "taskCreatetime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_createtime >=", value, "taskCreatetime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatetimeLessThan(Date value) {
            addCriterion("task_createtime <", value, "taskCreatetime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("task_createtime <=", value, "taskCreatetime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatetimeIn(List<Date> values) {
            addCriterion("task_createtime in", values, "taskCreatetime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatetimeNotIn(List<Date> values) {
            addCriterion("task_createtime not in", values, "taskCreatetime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatetimeBetween(Date value1, Date value2) {
            addCriterion("task_createtime between", value1, value2, "taskCreatetime");
            return (Criteria) this;
        }

        public Criteria andTaskCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("task_createtime not between", value1, value2, "taskCreatetime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishtimeIsNull() {
            addCriterion("task_finishtime is null");
            return (Criteria) this;
        }

        public Criteria andTaskFinishtimeIsNotNull() {
            addCriterion("task_finishtime is not null");
            return (Criteria) this;
        }

        public Criteria andTaskFinishtimeEqualTo(Date value) {
            addCriterion("task_finishtime =", value, "taskFinishtime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishtimeNotEqualTo(Date value) {
            addCriterion("task_finishtime <>", value, "taskFinishtime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishtimeGreaterThan(Date value) {
            addCriterion("task_finishtime >", value, "taskFinishtime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_finishtime >=", value, "taskFinishtime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishtimeLessThan(Date value) {
            addCriterion("task_finishtime <", value, "taskFinishtime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishtimeLessThanOrEqualTo(Date value) {
            addCriterion("task_finishtime <=", value, "taskFinishtime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishtimeIn(List<Date> values) {
            addCriterion("task_finishtime in", values, "taskFinishtime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishtimeNotIn(List<Date> values) {
            addCriterion("task_finishtime not in", values, "taskFinishtime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishtimeBetween(Date value1, Date value2) {
            addCriterion("task_finishtime between", value1, value2, "taskFinishtime");
            return (Criteria) this;
        }

        public Criteria andTaskFinishtimeNotBetween(Date value1, Date value2) {
            addCriterion("task_finishtime not between", value1, value2, "taskFinishtime");
            return (Criteria) this;
        }

        public Criteria andTaskUserIsNull() {
            addCriterion("task_user is null");
            return (Criteria) this;
        }

        public Criteria andTaskUserIsNotNull() {
            addCriterion("task_user is not null");
            return (Criteria) this;
        }

        public Criteria andTaskUserEqualTo(Integer value) {
            addCriterion("task_user =", value, "taskUser");
            return (Criteria) this;
        }

        public Criteria andTaskUserNotEqualTo(Integer value) {
            addCriterion("task_user <>", value, "taskUser");
            return (Criteria) this;
        }

        public Criteria andTaskUserGreaterThan(Integer value) {
            addCriterion("task_user >", value, "taskUser");
            return (Criteria) this;
        }

        public Criteria andTaskUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_user >=", value, "taskUser");
            return (Criteria) this;
        }

        public Criteria andTaskUserLessThan(Integer value) {
            addCriterion("task_user <", value, "taskUser");
            return (Criteria) this;
        }

        public Criteria andTaskUserLessThanOrEqualTo(Integer value) {
            addCriterion("task_user <=", value, "taskUser");
            return (Criteria) this;
        }

        public Criteria andTaskUserIn(List<Integer> values) {
            addCriterion("task_user in", values, "taskUser");
            return (Criteria) this;
        }

        public Criteria andTaskUserNotIn(List<Integer> values) {
            addCriterion("task_user not in", values, "taskUser");
            return (Criteria) this;
        }

        public Criteria andTaskUserBetween(Integer value1, Integer value2) {
            addCriterion("task_user between", value1, value2, "taskUser");
            return (Criteria) this;
        }

        public Criteria andTaskUserNotBetween(Integer value1, Integer value2) {
            addCriterion("task_user not between", value1, value2, "taskUser");
            return (Criteria) this;
        }

        public Criteria andTaskAssignerIsNull() {
            addCriterion("task_assigner is null");
            return (Criteria) this;
        }

        public Criteria andTaskAssignerIsNotNull() {
            addCriterion("task_assigner is not null");
            return (Criteria) this;
        }

        public Criteria andTaskAssignerEqualTo(Integer value) {
            addCriterion("task_assigner =", value, "taskAssigner");
            return (Criteria) this;
        }

        public Criteria andTaskAssignerNotEqualTo(Integer value) {
            addCriterion("task_assigner <>", value, "taskAssigner");
            return (Criteria) this;
        }

        public Criteria andTaskAssignerGreaterThan(Integer value) {
            addCriterion("task_assigner >", value, "taskAssigner");
            return (Criteria) this;
        }

        public Criteria andTaskAssignerGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_assigner >=", value, "taskAssigner");
            return (Criteria) this;
        }

        public Criteria andTaskAssignerLessThan(Integer value) {
            addCriterion("task_assigner <", value, "taskAssigner");
            return (Criteria) this;
        }

        public Criteria andTaskAssignerLessThanOrEqualTo(Integer value) {
            addCriterion("task_assigner <=", value, "taskAssigner");
            return (Criteria) this;
        }

        public Criteria andTaskAssignerIn(List<Integer> values) {
            addCriterion("task_assigner in", values, "taskAssigner");
            return (Criteria) this;
        }

        public Criteria andTaskAssignerNotIn(List<Integer> values) {
            addCriterion("task_assigner not in", values, "taskAssigner");
            return (Criteria) this;
        }

        public Criteria andTaskAssignerBetween(Integer value1, Integer value2) {
            addCriterion("task_assigner between", value1, value2, "taskAssigner");
            return (Criteria) this;
        }

        public Criteria andTaskAssignerNotBetween(Integer value1, Integer value2) {
            addCriterion("task_assigner not between", value1, value2, "taskAssigner");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
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