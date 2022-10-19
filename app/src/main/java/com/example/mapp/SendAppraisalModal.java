package com.example.mapp;

import android.os.Parcel;
import android.os.Parcelable;

public class SendAppraisalModal implements Parcelable {
    private String objective;
    private String indicators;
    private String proofofresult;
    private String agreedtargets;
    private String selfmark;

    private String treainingduration;
    private String comments;
    private String agreedtraining;

    private String professionalism;
    private String technicalcompetency;
    private String teamwork;

    public SendAppraisalModal() {
    }

    public SendAppraisalModal(String objective, String indicators, String proofofresult, String agreedtargets,
                              String selfmark,String agreedtraining,String treainingduration,String comments,String professionalism,
                              String teamwork,String technicalcompetency)
    {
        this.objective = objective;
        this.indicators = indicators;
        this.proofofresult = proofofresult;
        this.agreedtargets = agreedtargets;
        this.selfmark = selfmark;

      this.treainingduration = treainingduration;
        this.comments = comments;
        this.agreedtraining = agreedtraining;

        this.professionalism = professionalism;
        this.technicalcompetency = technicalcompetency;
        this.teamwork = teamwork;
    }

    protected SendAppraisalModal(Parcel in) {
        objective = in.readString();
        indicators = in.readString();
        proofofresult = in.readString();
        agreedtargets = in.readString();
        selfmark = in.readString();

        treainingduration = in.readString();
        comments = in.readString();
        agreedtraining = in.readString();

       professionalism = in.readString();
       technicalcompetency = in.readString();
       teamwork = in.readString();
    }

    public static final Creator<SendAppraisalModal> CREATOR = new Creator<SendAppraisalModal>() {
        @Override
        public SendAppraisalModal createFromParcel(Parcel in) {
            return new SendAppraisalModal(in);
        }

        @Override
        public SendAppraisalModal[] newArray(int size) {
            return new SendAppraisalModal[size];
        }
    };

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getIndicators() {
        return indicators;
    }

    public void setIndicators(String indicators) {
        this.indicators = indicators;
    }

    public String getProofofresult() {
        return proofofresult;
    }

    public void setProofofresult(String proofofresult) {
        this.proofofresult = proofofresult;
    }

    public String getAgreedtargets() {
        return agreedtargets;
    }

    public void setAgreedtargets(String agreedtargets) {
        this.agreedtargets = agreedtargets;
    }

    public String getSelfmark() {
        return selfmark;
    }

    public void setSelfmark(String selfmark) {
        this.selfmark = selfmark;
    }

    public String getTreainingduration() {
        return treainingduration;
    }

    public void setTreainingduration(String treainingduration) {
        this.treainingduration = treainingduration;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAgreedtraining() {
        return agreedtraining;
    }

    public void setAgreedtraining(String agreedtraining) {
        this.agreedtraining = agreedtraining;
    }

    public String getProfessionalism() {
        return professionalism;
    }

    public void setProfessionalism(String professionalism) {
        this.professionalism = professionalism;
    }

    public String getTechnicalcompetency() {
        return technicalcompetency;
    }

    public void setTechnicalcompetency(String technicalcompetency) {
        this.technicalcompetency = technicalcompetency;
    }

    public String getTeamwork() {
        return teamwork;
    }

    public void setTeamwork(String teamwork) {
        this.teamwork = teamwork;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(objective);
        parcel.writeString(indicators);
        parcel.writeString(proofofresult);
        parcel.writeString(agreedtargets);
        parcel.writeString(selfmark);
        parcel.writeString(treainingduration);
        parcel.writeString(comments);
        parcel.writeString(agreedtraining);
        parcel.writeString(professionalism);
        parcel.writeString(technicalcompetency);
        parcel.writeString(teamwork);
    }
}
