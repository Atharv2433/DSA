#include <iostream>
#include <vector>
#include <map>
#include <set>
#include <cmath>
#include <algorithm>

using namespace std;

struct Segment {
    int x_start, y_start, x_end, y_end;
};

int calculateCellCount(Segment segment, pair<int, int> crossing_point, bool isSplit) {
    if (segment.x_start == segment.x_end) {
        if (isSplit) {
            return min(abs(crossing_point.second - segment.y_start), abs(crossing_point.second - segment.y_end)) + 1;
        } 
        else {
            return abs(segment.y_start - segment.y_end) + 1;
        }
    } 
    else {
        if (isSplit) {
            return min(abs(crossing_point.first - segment.x_start), abs(crossing_point.first - segment.x_end)) + 1;
        } 
        else {
            return abs(segment.x_start - segment.x_end) + 1;
        }
    }
}

bool isIntersection(Segment seg1, Segment seg2, pair<int, int>& intersection_point) {
    if (seg1.x_start == seg1.x_end && seg2.y_start == seg2.y_end) {
        if (seg2.x_start <= seg1.x_start && seg1.x_start <= seg2.x_end && seg1.y_start <= seg2.y_start && seg2.y_start <= seg1.y_end) {
            intersection_point = {seg1.x_start, seg2.y_start};
            return true;
        }
    }
    if (seg1.y_start == seg1.y_end && seg2.x_start == seg2.x_end) {
        if (seg1.x_start <= seg2.x_start && seg2.x_start <= seg1.x_end && seg2.y_start <= seg1.y_start && seg1.y_start <= seg2.y_end) {
            intersection_point = {seg2.x_start, seg1.y_start};
            return true;
        }
    }
    return false;
}

int main() {
    int num_segments, min_intersections;
    cin >> num_segments;
    vector<Segment> segments(num_segments);
    for (int i = 0; i < num_segments; ++i) {
        cin >> segments[i].x_start >> segments[i].y_start >> segments[i].x_end >> segments[i].y_end;
        if (segments[i].x_start > segments[i].x_end || 
           (segments[i].x_start == segments[i].x_end && segments[i].y_start > segments[i].y_end)) {
            swap(segments[i].x_start, segments[i].x_end);
            swap(segments[i].y_start, segments[i].y_end);
        }
    }
    cin >> min_intersections;

    map<pair<int, int>, vector<Segment>> crossing_points;
    for (int i = 0; i < num_segments; ++i) {
        for (int j = i + 1; j < num_segments; ++j) {
            pair<int, int> intersection_point;
            if (isIntersection(segments[i], segments[j], intersection_point)) {
                crossing_points[intersection_point].push_back(segments[i]);
                crossing_points[intersection_point].push_back(segments[j]);
            }
        }
    }

    int total_cells = 0;
    for (auto& crossing : crossing_points) {
        if (crossing.second.size() / 2 == min_intersections) {
            vector<int> segment_intensities;
            for (auto& segment : crossing.second) {
                segment_intensities.push_back(calculateCellCount(segment, crossing.first, true));
            }
            total_cells += *min_element(segment_intensities.begin(), segment_intensities.end());
        }
    }
    cout << total_cells << endl;
    return 0;
}
