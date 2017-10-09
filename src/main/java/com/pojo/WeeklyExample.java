package com.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeeklyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public WeeklyExample() {
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

        public Criteria andWeeklyIdIsNull() {
            addCriterion("weekly_id is null");
            return (Criteria) this;
        }

        public Criteria andWeeklyIdIsNotNull() {
            addCriterion("weekly_id is not null");
            return (Criteria) this;
        }

        public Criteria andWeeklyIdEqualTo(Integer value) {
            addCriterion("weekly_id =", value, "weeklyId");
            return (Criteria) this;
        }

        public Criteria andWeeklyIdNotEqualTo(Integer value) {
            addCriterion("weekly_id <>", value, "weeklyId");
            return (Criteria) this;
        }

        public Criteria andWeeklyIdGreaterThan(Integer value) {
            addCriterion("weekly_id >", value, "weeklyId");
            return (Criteria) this;
        }

        public Criteria andWeeklyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("weekly_id >=", value, "weeklyId");
            return (Criteria) this;
        }

        public Criteria andWeeklyIdLessThan(Integer value) {
            addCriterion("weekly_id <", value, "weeklyId");
            return (Criteria) this;
        }

        public Criteria andWeeklyIdLessThanOrEqualTo(Integer value) {
            addCriterion("weekly_id <=", value, "weeklyId");
            return (Criteria) this;
        }

        public Criteria andWeeklyIdIn(List<Integer> values) {
            addCriterion("weekly_id in", values, "weeklyId");
            return (Criteria) this;
        }

        public Criteria andWeeklyIdNotIn(List<Integer> values) {
            addCriterion("weekly_id not in", values, "weeklyId");
            return (Criteria) this;
        }

        public Criteria andWeeklyIdBetween(Integer value1, Integer value2) {
            addCriterion("weekly_id between", value1, value2, "weeklyId");
            return (Criteria) this;
        }

        public Criteria andWeeklyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("weekly_id not between", value1, value2, "weeklyId");
            return (Criteria) this;
        }

        public Criteria andWTimeIsNull() {
            addCriterion("w_time is null");
            return (Criteria) this;
        }

        public Criteria andWTimeIsNotNull() {
            addCriterion("w_time is not null");
            return (Criteria) this;
        }

        public Criteria andWTimeEqualTo(Date value) {
            addCriterion("w_time =", value, "wTime");
            return (Criteria) this;
        }

        public Criteria andWTimeNotEqualTo(Date value) {
            addCriterion("w_time <>", value, "wTime");
            return (Criteria) this;
        }

        public Criteria andWTimeGreaterThan(Date value) {
            addCriterion("w_time >", value, "wTime");
            return (Criteria) this;
        }

        public Criteria andWTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("w_time >=", value, "wTime");
            return (Criteria) this;
        }

        public Criteria andWTimeLessThan(Date value) {
            addCriterion("w_time <", value, "wTime");
            return (Criteria) this;
        }

        public Criteria andWTimeLessThanOrEqualTo(Date value) {
            addCriterion("w_time <=", value, "wTime");
            return (Criteria) this;
        }

        public Criteria andWTimeIn(List<Date> values) {
            addCriterion("w_time in", values, "wTime");
            return (Criteria) this;
        }

        public Criteria andWTimeNotIn(List<Date> values) {
            addCriterion("w_time not in", values, "wTime");
            return (Criteria) this;
        }

        public Criteria andWTimeBetween(Date value1, Date value2) {
            addCriterion("w_time between", value1, value2, "wTime");
            return (Criteria) this;
        }

        public Criteria andWTimeNotBetween(Date value1, Date value2) {
            addCriterion("w_time not between", value1, value2, "wTime");
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

        public Criteria andWSummaryIsNull() {
            addCriterion("w_summary is null");
            return (Criteria) this;
        }

        public Criteria andWSummaryIsNotNull() {
            addCriterion("w_summary is not null");
            return (Criteria) this;
        }

        public Criteria andWSummaryEqualTo(String value) {
            addCriterion("w_summary =", value, "wSummary");
            return (Criteria) this;
        }

        public Criteria andWSummaryNotEqualTo(String value) {
            addCriterion("w_summary <>", value, "wSummary");
            return (Criteria) this;
        }

        public Criteria andWSummaryGreaterThan(String value) {
            addCriterion("w_summary >", value, "wSummary");
            return (Criteria) this;
        }

        public Criteria andWSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("w_summary >=", value, "wSummary");
            return (Criteria) this;
        }

        public Criteria andWSummaryLessThan(String value) {
            addCriterion("w_summary <", value, "wSummary");
            return (Criteria) this;
        }

        public Criteria andWSummaryLessThanOrEqualTo(String value) {
            addCriterion("w_summary <=", value, "wSummary");
            return (Criteria) this;
        }

        public Criteria andWSummaryLike(String value) {
            addCriterion("w_summary like", value, "wSummary");
            return (Criteria) this;
        }

        public Criteria andWSummaryNotLike(String value) {
            addCriterion("w_summary not like", value, "wSummary");
            return (Criteria) this;
        }

        public Criteria andWSummaryIn(List<String> values) {
            addCriterion("w_summary in", values, "wSummary");
            return (Criteria) this;
        }

        public Criteria andWSummaryNotIn(List<String> values) {
            addCriterion("w_summary not in", values, "wSummary");
            return (Criteria) this;
        }

        public Criteria andWSummaryBetween(String value1, String value2) {
            addCriterion("w_summary between", value1, value2, "wSummary");
            return (Criteria) this;
        }

        public Criteria andWSummaryNotBetween(String value1, String value2) {
            addCriterion("w_summary not between", value1, value2, "wSummary");
            return (Criteria) this;
        }

        public Criteria andWChallengeIsNull() {
            addCriterion("w_challenge is null");
            return (Criteria) this;
        }

        public Criteria andWChallengeIsNotNull() {
            addCriterion("w_challenge is not null");
            return (Criteria) this;
        }

        public Criteria andWChallengeEqualTo(String value) {
            addCriterion("w_challenge =", value, "wChallenge");
            return (Criteria) this;
        }

        public Criteria andWChallengeNotEqualTo(String value) {
            addCriterion("w_challenge <>", value, "wChallenge");
            return (Criteria) this;
        }

        public Criteria andWChallengeGreaterThan(String value) {
            addCriterion("w_challenge >", value, "wChallenge");
            return (Criteria) this;
        }

        public Criteria andWChallengeGreaterThanOrEqualTo(String value) {
            addCriterion("w_challenge >=", value, "wChallenge");
            return (Criteria) this;
        }

        public Criteria andWChallengeLessThan(String value) {
            addCriterion("w_challenge <", value, "wChallenge");
            return (Criteria) this;
        }

        public Criteria andWChallengeLessThanOrEqualTo(String value) {
            addCriterion("w_challenge <=", value, "wChallenge");
            return (Criteria) this;
        }

        public Criteria andWChallengeLike(String value) {
            addCriterion("w_challenge like", value, "wChallenge");
            return (Criteria) this;
        }

        public Criteria andWChallengeNotLike(String value) {
            addCriterion("w_challenge not like", value, "wChallenge");
            return (Criteria) this;
        }

        public Criteria andWChallengeIn(List<String> values) {
            addCriterion("w_challenge in", values, "wChallenge");
            return (Criteria) this;
        }

        public Criteria andWChallengeNotIn(List<String> values) {
            addCriterion("w_challenge not in", values, "wChallenge");
            return (Criteria) this;
        }

        public Criteria andWChallengeBetween(String value1, String value2) {
            addCriterion("w_challenge between", value1, value2, "wChallenge");
            return (Criteria) this;
        }

        public Criteria andWChallengeNotBetween(String value1, String value2) {
            addCriterion("w_challenge not between", value1, value2, "wChallenge");
            return (Criteria) this;
        }

        public Criteria andWTargetIsNull() {
            addCriterion("w_target is null");
            return (Criteria) this;
        }

        public Criteria andWTargetIsNotNull() {
            addCriterion("w_target is not null");
            return (Criteria) this;
        }

        public Criteria andWTargetEqualTo(String value) {
            addCriterion("w_target =", value, "wTarget");
            return (Criteria) this;
        }

        public Criteria andWTargetNotEqualTo(String value) {
            addCriterion("w_target <>", value, "wTarget");
            return (Criteria) this;
        }

        public Criteria andWTargetGreaterThan(String value) {
            addCriterion("w_target >", value, "wTarget");
            return (Criteria) this;
        }

        public Criteria andWTargetGreaterThanOrEqualTo(String value) {
            addCriterion("w_target >=", value, "wTarget");
            return (Criteria) this;
        }

        public Criteria andWTargetLessThan(String value) {
            addCriterion("w_target <", value, "wTarget");
            return (Criteria) this;
        }

        public Criteria andWTargetLessThanOrEqualTo(String value) {
            addCriterion("w_target <=", value, "wTarget");
            return (Criteria) this;
        }

        public Criteria andWTargetLike(String value) {
            addCriterion("w_target like", value, "wTarget");
            return (Criteria) this;
        }

        public Criteria andWTargetNotLike(String value) {
            addCriterion("w_target not like", value, "wTarget");
            return (Criteria) this;
        }

        public Criteria andWTargetIn(List<String> values) {
            addCriterion("w_target in", values, "wTarget");
            return (Criteria) this;
        }

        public Criteria andWTargetNotIn(List<String> values) {
            addCriterion("w_target not in", values, "wTarget");
            return (Criteria) this;
        }

        public Criteria andWTargetBetween(String value1, String value2) {
            addCriterion("w_target between", value1, value2, "wTarget");
            return (Criteria) this;
        }

        public Criteria andWTargetNotBetween(String value1, String value2) {
            addCriterion("w_target not between", value1, value2, "wTarget");
            return (Criteria) this;
        }

        public Criteria andWMethodIsNull() {
            addCriterion("w_method is null");
            return (Criteria) this;
        }

        public Criteria andWMethodIsNotNull() {
            addCriterion("w_method is not null");
            return (Criteria) this;
        }

        public Criteria andWMethodEqualTo(String value) {
            addCriterion("w_method =", value, "wMethod");
            return (Criteria) this;
        }

        public Criteria andWMethodNotEqualTo(String value) {
            addCriterion("w_method <>", value, "wMethod");
            return (Criteria) this;
        }

        public Criteria andWMethodGreaterThan(String value) {
            addCriterion("w_method >", value, "wMethod");
            return (Criteria) this;
        }

        public Criteria andWMethodGreaterThanOrEqualTo(String value) {
            addCriterion("w_method >=", value, "wMethod");
            return (Criteria) this;
        }

        public Criteria andWMethodLessThan(String value) {
            addCriterion("w_method <", value, "wMethod");
            return (Criteria) this;
        }

        public Criteria andWMethodLessThanOrEqualTo(String value) {
            addCriterion("w_method <=", value, "wMethod");
            return (Criteria) this;
        }

        public Criteria andWMethodLike(String value) {
            addCriterion("w_method like", value, "wMethod");
            return (Criteria) this;
        }

        public Criteria andWMethodNotLike(String value) {
            addCriterion("w_method not like", value, "wMethod");
            return (Criteria) this;
        }

        public Criteria andWMethodIn(List<String> values) {
            addCriterion("w_method in", values, "wMethod");
            return (Criteria) this;
        }

        public Criteria andWMethodNotIn(List<String> values) {
            addCriterion("w_method not in", values, "wMethod");
            return (Criteria) this;
        }

        public Criteria andWMethodBetween(String value1, String value2) {
            addCriterion("w_method between", value1, value2, "wMethod");
            return (Criteria) this;
        }

        public Criteria andWMethodNotBetween(String value1, String value2) {
            addCriterion("w_method not between", value1, value2, "wMethod");
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